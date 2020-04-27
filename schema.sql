-- Table: public.login

-- DROP TABLE public.login;

CREATE TABLE public.login
(
    id    uuid                                               NOT NULL,
    email character varying(60) COLLATE pg_catalog."default" NOT NULL,
    pwd   text COLLATE pg_catalog."default"                  NOT NULL,
    CONSTRAINT login_pkey PRIMARY KEY (id),
    CONSTRAINT "id user = id" FOREIGN KEY (id)
        REFERENCES public.login (id) MATCH FULL
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE public.login
    OWNER to postgres;

-- Table: public.list

-- DROP TABLE public.list;

CREATE TABLE public.list
(
    id       integer                           NOT NULL DEFAULT nextval('list_id_seq'::regclass),
    uuid     uuid                              NOT NULL,
    name     text COLLATE pg_catalog."default" NOT NULL,
    category text COLLATE pg_catalog."default" NOT NULL,
    date     text COLLATE pg_catalog."default" NOT NULL,
    priority text COLLATE pg_catalog."default",
    CONSTRAINT list_pkey PRIMARY KEY (id),
    CONSTRAINT list_uuid_fkey FOREIGN KEY (uuid)
        REFERENCES public.login (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.list
    OWNER to postgres;