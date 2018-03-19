insert into rooms(number,building,level) VALUES (120,'C1',1);
insert into rooms(number,building,level) VALUES (121,'C1',1);
insert into rooms(number,building,level) VALUES (122,'C1',1);
insert into rooms(number,building,level) VALUES (123,'C1',1);
insert into rooms(number,building,level) VALUES (124,'C1',1);
insert into rooms(number,building,level) VALUES (120,'C2',1);
insert into rooms(number,building,level) VALUES (121,'C2',1);
insert into rooms(number,building,level) VALUES (122,'C2',2);
insert into rooms(number,building,level) VALUES (123,'C2',2);
insert into rooms(number,building,level) VALUES (124,'C2',3);
insert into rooms(number,building,level) VALUES (125,'C2',3);

insert into specialization(name) values('Informatyka');
insert into specialization(name) values('Informatyka stosowana');
insert into specialization(name) values('Budownictwo');
insert into specialization(name) values('Automatyka i Robotyka');
insert into specialization(name) values('Mechanika i Budowa Maszyn');
insert into specialization(name) values('Inżynieria środowiska');
insert into specialization(name) values('Kulturoznawstwo');

insert into subjects(name,description) VALUES ('Bazy danych',' Dość ważny i potrzebny przedmiot. W wielu projektach stosuje się bazę do przechowywania danych. Na zajęciach poznamy język SQL i teorię stojącą za relacyjnym modelem. Na laborkach pracujemy w PostgreSQL.');
insert into subjects(name,description) VALUES ('Analiza matematyczna','Analiza to przedmiot najtrudniejszy w semestrze i gorąco zachęcamy do jego regularnej nauki.');
insert into subjects(name,description) VALUES ('Matematyka Dyskretna','Kolejny matematyczny przedmiot. Tym razem nieco przyjemniejszy - zagadnienia na nim poruszane mają spory związek z algorytmiką.');
insert into subjects(name,description) VALUES ('Fizyka','Przedmiot obejmuje spooooro materiału: kinematyka, dynamika, relatywistyka, elektryczność i magnetyzm, lasery i holografia, optyka.');
insert into subjects(name,description) VALUES ('Grafika komputerowa','Dość luźny przedmiot. Wykłady nie są do szczęścia potrzebne, mają więcej wspólnego z przetwarzaniem obrazu niż z tematyką zajęć.');
insert into subjects(name,description) VALUES ('Inżynieria Oprogramowania','Poznamy wszelakie diagramy, w tym UML. Okazują się one bardzo pomocne przy projektowaniu różnorakich systemów i często przydają się w rzeczywistej pracy, mówiąc z autopsji. Niestety, prowadzący masakrują go niczym Freddie Kruger.');
insert into subjects(name,description) VALUES ('Równania różniczkowe','Wykłady godne polecenia dla samego poczucia humoru wykładowcy. ');
insert into subjects(name,description) VALUES ('Aplikacje mobilne','Do zrobienia są trzy projekty, nie ma szans się wyrobić na zajęciach, więc trzeba było ogarnąć maca/wirtualkę.');
insert into subjects(name,description) VALUES ('Automatyka','Generalnie uczyliśmy się o transmitancjach, odpowiedziach różnych obiektów, rodzajach regulatorów (PID, kompensacja lead/lag), itd');
insert into subjects(name,description) VALUES ('Systemy dynamiczne','Uczymy się modelować systemy (głównie fizyczne), badać ich stabilność, itd. Do tego wykorzystujemy Matlaba.');


insert into role(name) VALUES ('ROLE_ADMIN');
insert into role(name) VALUES ('ROLE_STUDENT');
insert into role(name) VALUES ('ROLE_EMPLOYEE');

insert into employees(name,surname,birth_date,start_consultation_time,end_consultation_time,consultation_day,id_room)
values ('Zdzislaw','Paleta',date '1969-11-02',	time '16:00:00',time '17:00:00','Monday',1 );
insert into employees(name,surname,birth_date,start_consultation_time,end_consultation_time,consultation_day,id_room)
values ('Marek','Zyk',date '1979-11-02',	time '15:00:00',time '16:00:00','Thuesday',1 );
insert into employees(name,surname,birth_date,start_consultation_time,end_consultation_time,consultation_day,id_room)
values ('Tomek','Pele',date '1969-11-02',	time '16:00:00',time '17:00:00','Wednesday',3 );
insert into employees(name,surname,birth_date,start_consultation_time,end_consultation_time,consultation_day,id_room)
values ('Andrzej','Typowy',date '1969-12-12',	time '8:00:00',time '9:00:00','Friday',2 );
  
insert into "group"(name,year,id_specialization) values ('Dziekańska 1',2,1);
insert into "group"(name,year,id_specialization) values ('Dziekańska 1',3,1);
insert into "group"(name,year,id_specialization) values ('Dziekańska 2',2,1);
insert into "group"(name,year,id_specialization) values ('Dziekańska 3',2,1);
insert into "group"(name,year,id_specialization) values ('Dziekańska 2',3,1);
insert into "group"(name,year,id_specialization) values ('Dziekańska 3',3,1);
insert into "group"(name,year,id_specialization) values ('Dziekańska 1',1,1);

insert into student(name,surname,birth_date,sex,id_group)
VALUES ('Ida','Oskar', date '1989-05-04', 'female', 1);
insert into student(name,surname,birth_date,sex,id_group)
VALUES ('Filip','Hajzer', date '1989-03-04', 'male', 1);
insert into student(name,surname,birth_date,sex,id_group)
VALUES ('Piotr','Marek', date '1990-04-05', 'male', 2);
insert into student(name,surname,birth_date,sex,id_group)
VALUES ('Damian','Koks', date '1990-04-03', 'male', 3);
insert into student(name,surname,birth_date,sex,id_group)
VALUES ('Szymon','Jakoktochce', date '1991-03-03', 'male', 3);

insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (1, 1, TIMESTAMP '2017-12-04 09:00:00', TIMESTAMP '2017-12-04 10:30:00',213);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (1, 2, TIMESTAMP '2017-12-04 12:00:00', TIMESTAMP '2017-12-04 14:30:00',323);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (1, 3, TIMESTAMP '2017-12-05 13:00:00', TIMESTAMP '2017-12-04 15:00:00',100);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (1, 4, TIMESTAMP '2017-12-06 09:00:00', TIMESTAMP '2017-12-04 10:30:00',412);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (1, 5, TIMESTAMP '2017-12-07 12:00:00', TIMESTAMP '2017-12-04 13:30:00',222);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (1, 6, TIMESTAMP '2017-12-07 09:00:00', TIMESTAMP '2017-12-04 10:30:00',444);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (2, 7, TIMESTAMP '2017-12-04 09:00:00', TIMESTAMP '2017-12-04 10:30:00',252);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (2, 8, TIMESTAMP '2017-12-04 11:00:00', TIMESTAMP '2017-12-04 12:30:00',123);
insert into schedule(id_group, id_subject, data_start, data_end,room_number) values (2, 9, TIMESTAMP '2017-12-04 13:00:00', TIMESTAMP '2017-12-04 15:30:00',124);

insert into assignation(id_employee, id_subject) VALUES(1,1);
insert into assignation(id_employee, id_subject) VALUES(2,2);
insert into assignation(id_employee, id_subject) VALUES(3,3);
insert into assignation(id_employee, id_subject) VALUES(4,4);
insert into assignation(id_employee, id_subject) VALUES(1,5);
insert into assignation(id_employee, id_subject) VALUES(2,6);
insert into assignation(id_employee, id_subject) VALUES(1,7);
insert into assignation(id_employee, id_subject) VALUES(4,8);
insert into assignation(id_employee, id_subject) VALUES(2,9);
insert into assignation(id_employee, id_subject) VALUES(3,10);

insert into users(username,password,active,id_employee,id_student,id_role)
    values('233423','test',false,1,null,3);
insert into users(username,password,active,id_employee,id_student,id_role)
values('233433','test',false,2,null,3);
insert into users(username,password,active,id_employee,id_student,id_role)
values('235623','test',false,3,null,3);
insert into users(username,password,active,id_employee,id_student,id_role)
values('234523','test',false,4,null,3);


insert into users(username,password,active,id_employee,id_student,id_role)
values('233323','test',false,null,1,2);
insert into users(username,password,active,id_employee,id_student,id_role)
values('276523','test',false,null,2,2);
insert into users(username,password,active,id_employee,id_student,id_role)
values('238653','test',false,null,3,2);
insert into users(username,password,active,id_employee,id_student,id_role)
values('295673','test',false,null,4,2);
insert into users(username,password,active,id_employee,id_student,id_role)
values('234523','test',false,null,5,2);

insert into scores(value, name, id_subject, id_student) VALUES(3.5,'Kolos 1',1,1);
insert into scores(value, name, id_subject, id_student) VALUES(2.0,'Kolos 2',1,1);
insert into scores(value, name, id_subject, id_student) VALUES(5.0,'Kolos 1',2,1);
insert into scores(value, name, id_subject, id_student) VALUES(4.5,'Kolos 1',3,1);
insert into scores(value, name, id_subject, id_student) VALUES(4.5,'Kolos 1',4,1);
insert into scores(value, name, id_subject, id_student) VALUES(4.0,'Kolos 1',5,1);
