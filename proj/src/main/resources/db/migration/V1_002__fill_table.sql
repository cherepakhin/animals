insert into animal(id,name) values(0,'Заяц');
insert into animal(id,name) values(1,'Волк');
insert into animal(id,name) values(2,'Корова');

insert into country(id,name) values(0,'Россия');
insert into country(id,name) values(1,'Германия');

-- Россия
insert into statistic(id, animal_id,country_id, qty) values(0,0,0,0);
insert into statistic(id, animal_id,country_id, qty) values(1,1,0,10);
insert into statistic(id, animal_id,country_id, qty) values(2,2,0,20);
-- Германия
insert into statistic(id, animal_id,country_id, qty) values(3,0,1,30);
insert into statistic(id, animal_id,country_id, qty) values(4,1,1,40);
insert into statistic(id, animal_id,country_id, qty) values(5,2,1,50);

