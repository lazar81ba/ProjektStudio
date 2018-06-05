INSERT INTO public.role (name) VALUES
  ('Student'),
  ('Prowadzacy');

INSERT INTO public.user (university_index,password,active,id_role) VALUES
  ('254213','password1',TRUE ,1),
  ('223123','password2',TRUE,1),
  ('253233','password3',TRUE,1),
  ('adasow','password11',TRUE,2),
  ('tomwal','password12',TRUE,2),
  ('alekow','password12',TRUE,2),
  ('testProwadzacy2','password12',TRUE,2);

INSERT INTO public.specialization (name) VALUES
  ('Informatyka'),
  ('Automatyka'),
  ('Teleinformatyka');


INSERT INTO public.group (name,year,id_specialization) VALUES
  ('1a',2018,1),
  ('1b',2018,1),
  ('2a',2018,1),
  ('2b',2018,1),
  ('1a',2018,2),
  ('1b',2018,2),
  ('1a',2018,3),
  ('1b',2018,3);

INSERT INTO public.student (name,surname,birth_date,sex,university_index,id_group) VALUES
  ('Andrzej','Nowak','1996-04-01','male','254213',1),
  ('Tomasz','Kowalski','1995-04-01','male','223123',3),
  ('Aleksandra','Nowak','1996-09-11','female','253233',2);

INSERT INTO public.subject (name,description) VALUES
  ('Matematyka 1', 'Matematyka wprowadzajaca'),
  ('Fizyka 1', 'Fizyka wprowadzajaca'),
  ('Wprowadzenie do informatyki', 'Informatyka na 1. stopniu informatyki'),
  ('Programowanie obektowe', 'Podstawy programowania obiektowego'),
  ('Sieci' , 'Podstawy nauki o sieciach'),
  ('Bazy danych' , 'Bazy danych SQL');

INSERT INTO public.score (value,name,id_student,id_subject) VALUES
  (5,'5.0',1,1),
  (2,'2.0',2,1),
  (3,'3.0',3,1),
  (4,'4.0',1,2),
  (4,'4.0',2,2),
  (5,'5.0',3,2),
  (3.5,'3.5',1,3),
  (4.5,'4.5',2,3),
  (5,'5.0',3,3),
  (3,'3.0',1,4),
  (3,'3.0',2,4),
  (3,'3.0',3,4),
  (2,'2.0',1,5),
  (2,'2.0',2,5),
  (3.5,'3.5',3,5),
  (5,'5.0',1,6),
  (4.5,'4.5',2,6),
  (4,'4.0',3,6);
  

INSERT INTO public.room (name,building,level) VALUES
  ('221','C1',2),
  ('341','B1',3),
  ('228','B1',2),
  ('441','C3',4),
  ('112','C3',1);

INSERT INTO public.employee (name,surname,birth_date,consultation_day,start_consultation_time,end_consultation_time,university_nick,id_room) VALUES
  ('Adam','Sowa','1975-12-01','Monday','12:00','13:00','adasow',2),
  ('Tomasz','Walczak','1981-06-20','Firday','17:00','18:00','tomwal',1),
  ('Aleksandra','Kowalska','1991-08-25','Thursday','10:00','11:00','alekow',3);
INSERT INTO public.assignation (id_subject,id_employee) VALUES
  (1,1),
  (2,1),
  (3,2),
  (4,2),
  (5,3),
  (6,3);

INSERT INTO public.schedule (id_subject,id_group,id_room,data_start,data_end) VALUES
  (1,1,1,'2018-06-06 10:00:00','2018-06-06 11:30:00'),
  (1,2,1,'2018-06-07 10:00:00','2018-06-07 11:30:00'),
  (1,5,1,'2018-06-06 11:30:00','2018-06-06 13:00:00'),
  (1,6,1,'2018-06-07 11:30:00','2018-06-07 13:00:00'),
  (2,1,2,'2018-06-09 08:00:00','2018-06-09 09:30:00'),
  (2,2,2,'2018-06-09 09:30:00','2018-06-09 11:00:00'),
  (2,5,2,'2018-06-09 11:00:00','2018-06-09 12:30:00'),
  (2,6,2,'2018-06-09 12:30:00','2018-06-09 14:00:00'),
  (3,1,3,'2018-06-10 12:30:00','2018-06-10 14:00:00'),
  (3,2,3,'2018-06-10 14:00:00','2018-06-10 15:30:00'),
  (3,5,3,'2018-06-10 15:30:00','2018-06-10 17:00:00'),
  (3,6,3,'2018-06-10 17:00:00','2018-06-10 18:30:00');
  


