--
-- PostgreSQL database dump
--

-- Dumped from database version 16.9 (Homebrew)
-- Dumped by pg_dump version 16.9 (Homebrew)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: army; Type: TABLE; Schema: public; Owner: bastienvitour
--

CREATE TABLE public.army (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.army OWNER TO bastienvitour;

--
-- Name: army_id_seq; Type: SEQUENCE; Schema: public; Owner: bastienvitour
--

CREATE SEQUENCE public.army_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.army_id_seq OWNER TO bastienvitour;

--
-- Name: army_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bastienvitour
--

ALTER SEQUENCE public.army_id_seq OWNED BY public.army.id;


--
-- Name: character; Type: TABLE; Schema: public; Owner: bastienvitour
--

CREATE TABLE public."character" (
    id integer NOT NULL,
    name character varying NOT NULL,
    strength integer DEFAULT 0 NOT NULL,
    agility integer DEFAULT 0 NOT NULL,
    intelligence integer DEFAULT 0 NOT NULL,
    party_id integer,
    health_points integer DEFAULT 0 NOT NULL
);


ALTER TABLE public."character" OWNER TO bastienvitour;

--
-- Name: character_id_seq; Type: SEQUENCE; Schema: public; Owner: bastienvitour
--

CREATE SEQUENCE public.character_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.character_id_seq OWNER TO bastienvitour;

--
-- Name: character_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bastienvitour
--

ALTER SEQUENCE public.character_id_seq OWNED BY public."character".id;


--
-- Name: fight_log; Type: TABLE; Schema: public; Owner: bastienvitour
--

CREATE TABLE public.fight_log (
    id integer NOT NULL,
    character1 character varying NOT NULL,
    character2 character varying NOT NULL,
    datetime timestamp with time zone NOT NULL,
    winner character varying NOT NULL,
    action_log character varying NOT NULL
);


ALTER TABLE public.fight_log OWNER TO bastienvitour;

--
-- Name: fight_log_id_seq; Type: SEQUENCE; Schema: public; Owner: bastienvitour
--

CREATE SEQUENCE public.fight_log_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.fight_log_id_seq OWNER TO bastienvitour;

--
-- Name: fight_log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bastienvitour
--

ALTER SEQUENCE public.fight_log_id_seq OWNED BY public.fight_log.id;


--
-- Name: guild; Type: TABLE; Schema: public; Owner: bastienvitour
--

CREATE TABLE public.guild (
    id integer NOT NULL,
    name character varying NOT NULL,
    army_id integer
);


ALTER TABLE public.guild OWNER TO bastienvitour;

--
-- Name: party_id_seq; Type: SEQUENCE; Schema: public; Owner: bastienvitour
--

CREATE SEQUENCE public.party_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.party_id_seq OWNER TO bastienvitour;

--
-- Name: party_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: bastienvitour
--

ALTER SEQUENCE public.party_id_seq OWNED BY public.guild.id;


--
-- Name: army id; Type: DEFAULT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.army ALTER COLUMN id SET DEFAULT nextval('public.army_id_seq'::regclass);


--
-- Name: character id; Type: DEFAULT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public."character" ALTER COLUMN id SET DEFAULT nextval('public.character_id_seq'::regclass);


--
-- Name: fight_log id; Type: DEFAULT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.fight_log ALTER COLUMN id SET DEFAULT nextval('public.fight_log_id_seq'::regclass);


--
-- Name: guild id; Type: DEFAULT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.guild ALTER COLUMN id SET DEFAULT nextval('public.party_id_seq'::regclass);


--
-- Data for Name: army; Type: TABLE DATA; Schema: public; Owner: bastienvitour
--

COPY public.army (id, name) FROM stdin;
\.


--
-- Data for Name: character; Type: TABLE DATA; Schema: public; Owner: bastienvitour
--

COPY public."character" (id, name, strength, agility, intelligence, party_id, health_points) FROM stdin;
6	Basvit	0	15	35	\N	60
7	Adam	25	15	10	\N	70
\.


--
-- Data for Name: fight_log; Type: TABLE DATA; Schema: public; Owner: bastienvitour
--

COPY public.fight_log (id, character1, character2, datetime, winner, action_log) FROM stdin;
1	Basvit	Adam	2026-01-09 16:32:10.777702+01	Adam	
2	Basvit	Adam	2026-01-09 16:43:58.629429+01	Adam	1A8-2A6-1A9-2A9-1A6-2A6-1A9-2A8-1A5-2A6-1A8-2A9-1A5-2A9-1A7-2A8-
\.


--
-- Data for Name: guild; Type: TABLE DATA; Schema: public; Owner: bastienvitour
--

COPY public.guild (id, name, army_id) FROM stdin;
\.


--
-- Name: army_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bastienvitour
--

SELECT pg_catalog.setval('public.army_id_seq', 3, true);


--
-- Name: character_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bastienvitour
--

SELECT pg_catalog.setval('public.character_id_seq', 7, true);


--
-- Name: fight_log_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bastienvitour
--

SELECT pg_catalog.setval('public.fight_log_id_seq', 2, true);


--
-- Name: party_id_seq; Type: SEQUENCE SET; Schema: public; Owner: bastienvitour
--

SELECT pg_catalog.setval('public.party_id_seq', 1, true);


--
-- Name: army Nom unique; Type: CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.army
    ADD CONSTRAINT "Nom unique" UNIQUE (name);


--
-- Name: character Unique name; Type: CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public."character"
    ADD CONSTRAINT "Unique name" UNIQUE (name);


--
-- Name: CONSTRAINT "Unique name" ON "character"; Type: COMMENT; Schema: public; Owner: bastienvitour
--

COMMENT ON CONSTRAINT "Unique name" ON public."character" IS 'The character name has to be unique';


--
-- Name: army army_pkey; Type: CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.army
    ADD CONSTRAINT army_pkey PRIMARY KEY (id);


--
-- Name: character character_pkey; Type: CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public."character"
    ADD CONSTRAINT character_pkey PRIMARY KEY (id);


--
-- Name: fight_log fight_log_pkey; Type: CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.fight_log
    ADD CONSTRAINT fight_log_pkey PRIMARY KEY (id);


--
-- Name: guild party_pkey; Type: CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.guild
    ADD CONSTRAINT party_pkey PRIMARY KEY (id);


--
-- Name: guild Army; Type: FK CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public.guild
    ADD CONSTRAINT "Army" FOREIGN KEY (army_id) REFERENCES public.army(id);


--
-- Name: character Party; Type: FK CONSTRAINT; Schema: public; Owner: bastienvitour
--

ALTER TABLE ONLY public."character"
    ADD CONSTRAINT "Party" FOREIGN KEY (party_id) REFERENCES public.guild(id) NOT VALID;


--
-- PostgreSQL database dump complete
--

