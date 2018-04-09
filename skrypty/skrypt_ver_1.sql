
CREATE TABLE IF NOT EXISTS public.user
(
  id serial not null
    constraint users_pkey
    primary key,
  university_index varchar(255),
  password varchar(255),
  active boolean,
  id_role integer
);


CREATE TABLE IF NOT EXISTS public.role
(
  id serial not null
    constraint role_pkey
    primary key,
  name varchar(255)
);

CREATE TABLE IF NOT EXISTS public.student
(
  id serial not null
    constraint student_pkey
    primary key,
  name varchar(255),
  surname varchar(255),
  birth_date date,
  sex varchar(10),
  university_index varchar(255) unique,
  id_group integer
);

CREATE TABLE IF NOT EXISTS public.score
(
  id serial not null
    constraint scores_pkey
    primary key,
  value double precision,
  name varchar(255),
  id_subject integer,
  id_student integer
);

CREATE TABLE IF NOT EXISTS public.group
(
  id serial not null
    constraint group_pkey
    primary key,
  name varchar(255),
  year integer,
  id_specialization integer
);

CREATE TABLE IF NOT EXISTS public.specialization
(
  id serial not null
    constraint specialization_pkey
    primary key,
  name varchar(255)
);

CREATE TABLE IF NOT EXISTS public.schedule
(
  id serial not null
    constraint schedule_pkey
    primary key,
  id_group integer not null,
  id_subject integer not null,
  data_start timestamp,
  data_end timestamp,
  id_room integer not null
);

CREATE TABLE IF NOT EXISTS public.subject
(
  id  serial not null
    constraint subjects_pkey
    primary key,
  name VARCHAR(255),
  description text
);

CREATE TABLE IF NOT EXISTS public.room
(
  id serial not null
    constraint rooms_pkey
    primary key,
  name varchar(255),
  building VARCHAR(255),
  level INT
);



CREATE TABLE IF NOT EXISTS public.employee
(
  id serial not null
    constraint employees_pkey
    primary key,
  name varchar(255),
  surname varchar(255),
  birth_date date,
  start_consultation_time TIME,
  end_consultation_time TIME,
  consultation_day varchar(255),
  university_nick varchar(255) unique,
  id_room integer not null
);

CREATE TABLE IF NOT EXISTS public.assignation
(
  id serial not null
    constraint assignation_pkey
    primary key,
  id_employee INTEGER,
  id_subject INTEGER
);




ALTER TABLE public.group ADD CONSTRAINT group_specialization_fkey FOREIGN KEY (id_specialization) REFERENCES public.specialization(id) ;
ALTER TABLE public.student ADD CONSTRAINT student_group_fkey FOREIGN KEY (id_group) REFERENCES public.group(id) ;
ALTER TABLE public.user ADD CONSTRAINT users_role_fkey FOREIGN KEY (id_role) REFERENCES public.role(id) ;
ALTER TABLE public.schedule ADD CONSTRAINT schedule_group_fkey FOREIGN KEY (id_group) REFERENCES public.group(id) ;
ALTER TABLE public.score ADD CONSTRAINT scores_student_fkey FOREIGN KEY (id_student) REFERENCES public.student(id) ;
ALTER TABLE public.assignation ADD CONSTRAINT assignation_employees_fkey FOREIGN KEY (id_employee) REFERENCES public.employee(id) ;
ALTER TABLE public.employee ADD CONSTRAINT employees_rooms_fkey FOREIGN KEY (id_room) REFERENCES public.room(id) ;
ALTER TABLE public.schedule ADD CONSTRAINT schedule_subject_fkey FOREIGN KEY (id_subject) REFERENCES public.subject(id) ;
ALTER TABLE public.assignation ADD CONSTRAINT assignation_subject_fkey FOREIGN KEY (id_subject) REFERENCES public.subject(id) ;
ALTER TABLE public.score ADD CONSTRAINT scores_subject_fkey FOREIGN KEY (id_subject) REFERENCES public.subject(id) ;
ALTER TABLE public.schedule ADD CONSTRAINT schedule_room_fkey FOREIGN KEY (id_room) REFERENCES public.room(id) ;
