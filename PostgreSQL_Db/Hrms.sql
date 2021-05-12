-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public."Candidates"
(
    id integer NOT NULL,
    firstname character varying(25) NOT NULL,
    lastname character varying(25) NOT NULL,
    identity_number character varying(11) NOT NULL,
    birthdate date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public."Employees"
(
    id integer NOT NULL,
    firstname character varying(25) NOT NULL,
    lastname character varying(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public."Employers"
(
    id integer NOT NULL,
    company_name character varying(30) NOT NULL,
    web_adress character varying(30) NOT NULL,
    phone_number character varying(12) NOT NULL,
    is_activated boolean,
    PRIMARY KEY (id)
);

CREATE TABLE public."Users"
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying(50) NOT NULL,
    password character varying(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.activation_code_candidates
(
    id integer NOT NULL,
    candidate_user_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.activation_code_employers
(
    id integer NOT NULL,
    employer_user_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.activation_codes
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    activation_code character varying(25) NOT NULL,
    is_confirmed boolean NOT NULL,
    confirm_date date,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers_activation_by_employees
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    employee_id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    confirm_date date,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "position" character varying(25) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public."Candidates"
    ADD FOREIGN KEY (id)
    REFERENCES public."Users" (id)
    NOT VALID;


ALTER TABLE public."Employees"
    ADD FOREIGN KEY (id)
    REFERENCES public."Users" (id)
    NOT VALID;


ALTER TABLE public."Employers"
    ADD FOREIGN KEY (id)
    REFERENCES public."Users" (id)
    NOT VALID;


ALTER TABLE public.activation_code_candidates
    ADD FOREIGN KEY (candidate_user_id)
    REFERENCES public."Candidates" (id)
    NOT VALID;


ALTER TABLE public.activation_code_candidates
    ADD FOREIGN KEY (id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public.activation_code_employers
    ADD FOREIGN KEY (employer_user_id)
    REFERENCES public."Employers" (id)
    NOT VALID;


ALTER TABLE public.activation_code_employers
    ADD FOREIGN KEY (id)
    REFERENCES public.activation_codes (id)
    NOT VALID;


ALTER TABLE public.employers_activation_by_employees
    ADD FOREIGN KEY (employee_id)
    REFERENCES public."Employees" (id)
    NOT VALID;


ALTER TABLE public.employers_activation_by_employees
    ADD FOREIGN KEY (employer_id)
    REFERENCES public."Employers" (id)
    NOT VALID;

END;