-- Create table to save the ngram data
create table if not exists ngram(
word string,
year int,
frequency int,
apprearence int)
comment 'this is the table for google ngram data'
row format delimited fields terminated by '\t';

-- Load data into the table ngram
load data inpath '/user/cloudera/bitboot/weeks/googlebooks.txt'
into table ngram;

-- Create view to save the word and its length
create view if not exists word_len(word, len) as
select distinct word, length(word) from ngram;

-- Compute the min,max,avg and std of word length
select min(len) as min ,max(len) as max,avg(len) as avg ,stddev_pop(len) as std
from word_len;


-- Create view to save word and the total year of the word
create view if not exists total_year(word, total) as
select word, count(*) as total from ngram
group by word
order by total desc;

-- Find out the 10 most common word
select * from total_year limit 10;

-- Compute the min, max, avg and std of the words' total year
select min(total) as min_year, max(total) as max_year,avg(total) as avg_year,stddev_pop(total) as std_year
from total_year;

-- Create view to save the word and its total frequency
create view if not exists frequency_total(word, total) as
select word,sum(frequency) as total from ngram
group by word
order by total desc;

-- Find out the 10 most common word by its total frequency
select * from frequency_total limit 10;

-- Compute the min,max,avg,std of words' total frequency
select min(total) as min,max(total) as max,avg(total) as avg,stddev_pop(total) as std
from frequency_total;




