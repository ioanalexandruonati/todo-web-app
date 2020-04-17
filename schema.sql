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


CREATE TABLE public.list
(
    id uuid NOT NULL,
    name character varying(10000) COLLATE pg_catalog."default",
    category character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT list_pkey PRIMARY KEY (id),
    CONSTRAINT list_id_fkey FOREIGN KEY (id)
        REFERENCES public.login (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.list
    OWNER to postgres;