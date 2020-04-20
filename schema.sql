-- Table: public.list

-- DROP TABLE public.list;

CREATE TABLE public.list
(
    id uuid NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    category text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT id PRIMARY KEY (id),
    CONSTRAINT "id user = id user" FOREIGN KEY (id)
        REFERENCES public.login (id) MATCH FULL
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.list
    OWNER to postgres;





-- Table: public.login

-- DROP TABLE public.login;

CREATE TABLE public.login
(
    id uuid NOT NULL,
    email character varying(32) COLLATE pg_catalog."default",
    pwd character varying(64) COLLATE pg_catalog."default",
    CONSTRAINT login_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.login
    OWNER to postgres;