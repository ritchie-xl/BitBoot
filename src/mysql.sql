create database if not exists ngram;
use ngram;

drop table if exists ngram;
create table ngram(
word text not null,
year integer not null,
frequency integer not null,
apprence integer not null
);

LOAD DATA local INFILE'/home/ritchie/week1/googlebook.txt' into table ngram
fields terminated by '\t';

-- Create view to save the word and its length
create view if not exists word_len(word, len) as
select distinct word, length(word) from ngram;

-- Compute the min,max,avg and std of word length
select min(len) as min ,max(len) as max,mean(len) as avg ,sd(len) as std
from word_len;


-- Create view to save word and the total year of the word
create view if not exists total_year(word, total) as
select word, count(*) as total from ngram
group by word
order by total desc;

-- Find out the 10 most common word
select * from total_year limit 10;

-- Compute the min, max, avg and std of the words' total year
select min(total) as min_year, max(total) as max_year,mean(total) as avg_year,sd(total) as std_year
from total_year;

-- Create view to save the word and its total frequency
create view if not exists frequency_total(word, total) as
select word,sum(frequency) as total from ngram
group by word
order by total desc;

-- Find out the 10 most common word by its total frequency
select * from frequency_total limit 10;

-- Compute the min,max,avg,std of words' total frequency
select min(total) as min,max(total) as max,mean(total) as avg,sd(total) as std
from frequency_total;