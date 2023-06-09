--
-- PostgreSQL database dump
--

-- Dumped from database version 14.7
-- Dumped by pg_dump version 14.7

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
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    cliente_id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    email character varying(50),
    telefono character varying(20),
    direccion character varying(100) NOT NULL,
    activo boolean
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: clientes_cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_cliente_id_seq OWNER TO postgres;

--
-- Name: clientes_cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_cliente_id_seq OWNED BY public.clientes.cliente_id;


--
-- Name: compra_materiales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compra_materiales (
    id integer NOT NULL,
    compra integer NOT NULL,
    material integer NOT NULL,
    cantidad integer
);


ALTER TABLE public.compra_materiales OWNER TO postgres;

--
-- Name: compra_materiales_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.compra_materiales_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compra_materiales_id_seq OWNER TO postgres;

--
-- Name: compra_materiales_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.compra_materiales_id_seq OWNED BY public.compra_materiales.id;


--
-- Name: insumos_en_stock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.insumos_en_stock (
    material_id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    cantidad integer,
    activo boolean
);


ALTER TABLE public.insumos_en_stock OWNER TO postgres;

--
-- Name: compra_plus; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.compra_plus AS
 SELECT compra_materiales.id,
    compra_materiales.compra,
    insumos_en_stock.nombre,
    compra_materiales.cantidad
   FROM (public.compra_materiales
     JOIN public.insumos_en_stock ON ((compra_materiales.material = insumos_en_stock.material_id)));


ALTER TABLE public.compra_plus OWNER TO postgres;

--
-- Name: compras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compras (
    id integer NOT NULL,
    fecha date,
    provedor integer NOT NULL
);


ALTER TABLE public.compras OWNER TO postgres;

--
-- Name: compras_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.compras_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compras_id_seq OWNER TO postgres;

--
-- Name: compras_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.compras_id_seq OWNED BY public.compras.id;


--
-- Name: maquina_insumos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.maquina_insumos (
    id integer NOT NULL,
    maquina integer,
    insumo integer,
    cantidad integer,
    activo boolean
);


ALTER TABLE public.maquina_insumos OWNER TO postgres;

--
-- Name: maquinas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.maquinas (
    id integer NOT NULL,
    nombre character varying NOT NULL,
    proporcion character varying,
    activo boolean
);


ALTER TABLE public.maquinas OWNER TO postgres;

--
-- Name: insumos_aso; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.insumos_aso AS
 SELECT maquina_insumos.id,
    maquinas.id AS maquina,
    insumos_en_stock.nombre AS material,
    maquina_insumos.cantidad,
    maquina_insumos.activo
   FROM ((public.insumos_en_stock
     JOIN public.maquina_insumos ON ((maquina_insumos.insumo = insumos_en_stock.material_id)))
     JOIN public.maquinas ON ((maquina_insumos.maquina = maquinas.id)));


ALTER TABLE public.insumos_aso OWNER TO postgres;

--
-- Name: insumos_en_stock_material_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.insumos_en_stock_material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.insumos_en_stock_material_id_seq OWNER TO postgres;

--
-- Name: insumos_en_stock_material_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.insumos_en_stock_material_id_seq OWNED BY public.insumos_en_stock.material_id;


--
-- Name: mantenimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mantenimientos (
    id integer NOT NULL,
    proyecto integer NOT NULL,
    fecha_i date NOT NULL,
    fecha_f date,
    personal integer NOT NULL
);


ALTER TABLE public.mantenimientos OWNER TO postgres;

--
-- Name: mantenimientos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.mantenimientos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mantenimientos_id_seq OWNER TO postgres;

--
-- Name: mantenimientos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.mantenimientos_id_seq OWNED BY public.mantenimientos.id;


--
-- Name: maquina_insumos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.maquina_insumos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.maquina_insumos_id_seq OWNER TO postgres;

--
-- Name: maquina_insumos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.maquina_insumos_id_seq OWNED BY public.maquina_insumos.id;


--
-- Name: maquinas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.maquinas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.maquinas_id_seq OWNER TO postgres;

--
-- Name: maquinas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.maquinas_id_seq OWNED BY public.maquinas.id;


--
-- Name: personal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personal (
    personal_id integer NOT NULL,
    nombre_1 character varying(50) NOT NULL,
    nombre_2 character varying(50),
    apellidos character varying(100) NOT NULL,
    puesto character varying(20) NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(40) NOT NULL,
    telefono character varying(20),
    activo boolean
);


ALTER TABLE public.personal OWNER TO postgres;

--
-- Name: personal_personal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.personal_personal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_personal_id_seq OWNER TO postgres;

--
-- Name: personal_personal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.personal_personal_id_seq OWNED BY public.personal.personal_id;


--
-- Name: provedores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.provedores (
    provedor_id integer NOT NULL,
    nombre character varying NOT NULL,
    email character varying,
    telefono character varying,
    activo boolean
);


ALTER TABLE public.provedores OWNER TO postgres;

--
-- Name: provedores_provedor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.provedores_provedor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.provedores_provedor_id_seq OWNER TO postgres;

--
-- Name: provedores_provedor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.provedores_provedor_id_seq OWNED BY public.provedores.provedor_id;


--
-- Name: proyectos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.proyectos (
    id integer NOT NULL,
    nombre character varying NOT NULL,
    fecha_i character varying NOT NULL,
    fecha_f character varying NOT NULL,
    cliente_id integer NOT NULL,
    maquina_id integer NOT NULL,
    activo boolean
);


ALTER TABLE public.proyectos OWNER TO postgres;

--
-- Name: proyectos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.proyectos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proyectos_id_seq OWNER TO postgres;

--
-- Name: proyectos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.proyectos_id_seq OWNED BY public.proyectos.id;


--
-- Name: vista_compras; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vista_compras AS
SELECT
    NULL::integer AS id,
    NULL::date AS fecha,
    NULL::character varying AS provedor,
    NULL::bigint AS materiales;


ALTER TABLE public.vista_compras OWNER TO postgres;

--
-- Name: vista_mantenimientos; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vista_mantenimientos AS
 SELECT mantenimientos.id,
    proyectos.nombre AS proyecto,
    mantenimientos.fecha_i,
    mantenimientos.fecha_f,
    personal.apellidos AS personal
   FROM ((public.mantenimientos
     JOIN public.personal ON ((mantenimientos.personal = personal.personal_id)))
     JOIN public.proyectos ON ((mantenimientos.proyecto = proyectos.id)));


ALTER TABLE public.vista_mantenimientos OWNER TO postgres;

--
-- Name: vista_maquinas; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vista_maquinas AS
SELECT
    NULL::integer AS id,
    NULL::character varying AS nombre,
    NULL::bigint AS materiales,
    NULL::character varying AS proporcion,
    NULL::boolean AS activo;


ALTER TABLE public.vista_maquinas OWNER TO postgres;

--
-- Name: vista_proyectos; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vista_proyectos AS
 SELECT proyectos.id,
    proyectos.nombre,
    proyectos.fecha_i,
    proyectos.fecha_f,
    clientes.nombre AS cliente,
    maquinas.nombre AS maquina,
    proyectos.activo
   FROM ((public.proyectos
     JOIN public.clientes ON ((proyectos.cliente_id = clientes.cliente_id)))
     JOIN public.maquinas ON ((proyectos.maquina_id = maquinas.id)));


ALTER TABLE public.vista_proyectos OWNER TO postgres;

--
-- Name: clientes cliente_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN cliente_id SET DEFAULT nextval('public.clientes_cliente_id_seq'::regclass);


--
-- Name: compra_materiales id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra_materiales ALTER COLUMN id SET DEFAULT nextval('public.compra_materiales_id_seq'::regclass);


--
-- Name: compras id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compras ALTER COLUMN id SET DEFAULT nextval('public.compras_id_seq'::regclass);


--
-- Name: insumos_en_stock material_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insumos_en_stock ALTER COLUMN material_id SET DEFAULT nextval('public.insumos_en_stock_material_id_seq'::regclass);


--
-- Name: mantenimientos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos ALTER COLUMN id SET DEFAULT nextval('public.mantenimientos_id_seq'::regclass);


--
-- Name: maquina_insumos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maquina_insumos ALTER COLUMN id SET DEFAULT nextval('public.maquina_insumos_id_seq'::regclass);


--
-- Name: maquinas id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maquinas ALTER COLUMN id SET DEFAULT nextval('public.maquinas_id_seq'::regclass);


--
-- Name: personal personal_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal ALTER COLUMN personal_id SET DEFAULT nextval('public.personal_personal_id_seq'::regclass);


--
-- Name: provedores provedor_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provedores ALTER COLUMN provedor_id SET DEFAULT nextval('public.provedores_provedor_id_seq'::regclass);


--
-- Name: proyectos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proyectos ALTER COLUMN id SET DEFAULT nextval('public.proyectos_id_seq'::regclass);


--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (cliente_id, nombre, email, telefono, direccion, activo) FROM stdin;
3	MaquinasMex	MaquinasMex@gmail.com	321-123-1221	Av. Los prados verdes	t
12	Clavos Mexico			Av Mexico 4433	f
13	hola			hola	f
17	a			a	f
18	x			x	f
19	f			f	f
16	sola		s	s	f
15	dfidjsjif	asfa	asd	sdasdsa	t
22	Zapatos			sd	t
23	Maquinas_mex	si	si	si	t
26	Metales_america	Metales_Mexico@mex.com	323-585-8888	Prados Verdes	t
25	Metales_Mexico	Metales_Mexico@mex.com	323-222-8888	Prados Verdes	t
27	Fabricas GDL	123@email.com	311-585-4148	Av Coyoacan	t
1	Bilsys	bilsi@correomex.com	332-121-4323	Av Popeyes	f
28	Jose			Oblatos	t
29	Antonio			21	f
30	carlos			vegetal	f
21	CUCEI	CUECEI.ESCOLAR@ALUMNO	323-525-4444	Oblatos 4000	t
20	miguel	hola32@gmail	123215	miguel	t
31	Maria Luisa	maria@hotmail.com	3112529898	Prados Tepeyac	t
\.


--
-- Data for Name: compra_materiales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.compra_materiales (id, compra, material, cantidad) FROM stdin;
1	1	2	200
4	2	7	50
3	1	1	400
5	6	8	20
6	6	2	300
\.


--
-- Data for Name: compras; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.compras (id, fecha, provedor) FROM stdin;
1	2023-05-21	6
5	2023-05-21	2
3	2023-05-22	1
4	2023-05-22	4
2	2023-05-22	2
6	2023-05-23	6
\.


--
-- Data for Name: insumos_en_stock; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.insumos_en_stock (material_id, nombre, cantidad, activo) FROM stdin;
3	Titanio	40	f
2	Acero	100	t
1	Metal	2000	t
6	Madera	500	f
5	Plasticos	2000	t
7	PBC	500	f
8	Tela	400	t
9	Carbono	500	t
4	Aluminio	25	t
15	Chip	20	t
\.


--
-- Data for Name: mantenimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mantenimientos (id, proyecto, fecha_i, fecha_f, personal) FROM stdin;
1	1	2023-03-03	2023-04-03	1
2	3	2023-05-22	2023-05-22	5
3	1	2023-05-22	2023-05-22	3
\.


--
-- Data for Name: maquina_insumos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.maquina_insumos (id, maquina, insumo, cantidad, activo) FROM stdin;
4	2	7	50	t
5	3	4	5	t
6	2	9	200	t
10	3	3	10	f
12	5	9	20	t
1	1	2	100	t
3	1	15	200	t
7	6	8	120	t
11	4	6	12	t
13	7	6	1111	t
14	8	7	20	t
15	8	9	200	t
\.


--
-- Data for Name: maquinas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.maquinas (id, nombre, proporcion, activo) FROM stdin;
1	Tractor 1	Mediano	t
2	Tractor 2	Mediano	t
4	Compresor	Peque├▒o	t
6	Computador	Grande	f
3	Tractor 300	Grande	t
5	Impresoras	Mediano	f
7	Apple	Grande	t
8	HP	Mediana	t
\.


--
-- Data for Name: personal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personal (personal_id, nombre_1, nombre_2, apellidos, puesto, email, password, telefono, activo) FROM stdin;
1	Oscar	Miguel	Gomez Lopez	Ingeniero	gomezoscarmiguel14@gmail.com	5ad837d962f33ff4976bb1630282d88d4bed8e27	311-131-2828	t
5	Aranza		G├│mez	Adminitrador	Gomez.Aranza13@hola.com	fc990074b174c9b756eab78c1e83520d02be49b4	311-585-8585	f
4	Antonio	Casas	Solas	Ingeniero	Sola.Ant@data.com	472eb8d8cde13efad50dddf512bb056305caeb32	311-252-4041	t
7	Jose		Gonzalo Carranza	Jefe General	123@gmail.com	6ca8c5d1412c05422e58597e82910f4c75526240	216-55-85	f
3	Manuel		Estrada	Tecnicos	manuel.Estrada@datagest.com	a49c6b8629aac772ba6ee34e340b8f2dcd79633d	323-525-2185	t
6	Maria	Aranza	De las Flores	Ingenieras	Aranza@maria.com	ac5d2c7268f48642f496c41b621daa56eeada807	311-585-8888	t
9	Carlos	Santiago	G├│nzalez Luna	Tecnico	Luna@email.com	6b388997437db275445842c3caa295165ff431c8	311-858-9393	t
2	Aldo	Manuel	Carios	Tecnico	aldo.carios2@datagest.com	4b73e4218d9ce389912cd98e01a6d79d92861099	311-131-2828	f
8	Joel	De Jes├║s	L├│pez Mezas	Licenciado	JesusdeJoel@datagest.com	a17408b80ea70c588439a56471f955bf294d2555	332-529-8989	t
\.


--
-- Data for Name: provedores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.provedores (provedor_id, nombre, email, telefono, activo) FROM stdin;
2	Jose Pablo Guadalupe	Guadalupe14@ms.ls	211-15-14	t
3	Clavos De Acero	Acero@clavos.mx.com	959-858-777	f
5	Maquinaria	Maquinaria@email.com	215-48-85	t
6	Jesus	jesus@jesus.com	311-858-9999	t
1	Tiendas_mexico	Tiendas_mexicoso@13.com	311-656-7474	t
4	Alfonsos	alfono@email.com	213-232-2443	t
\.


--
-- Data for Name: proyectos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.proyectos (id, nombre, fecha_i, fecha_f, cliente_id, maquina_id, activo) FROM stdin;
1	Proyecto_1	2023-04-19	2023-05-20	13	1	t
3	Proyecto Salamandra	2023-02-21	2023-02-02	3	4	t
2	Proyecto_23	2023-06-02	2023-02-03	27	6	t
\.


--
-- Name: clientes_cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_cliente_id_seq', 31, true);


--
-- Name: compra_materiales_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.compra_materiales_id_seq', 6, true);


--
-- Name: compras_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.compras_id_seq', 6, true);


--
-- Name: insumos_en_stock_material_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.insumos_en_stock_material_id_seq', 15, true);


--
-- Name: mantenimientos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.mantenimientos_id_seq', 3, true);


--
-- Name: maquina_insumos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.maquina_insumos_id_seq', 15, true);


--
-- Name: maquinas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.maquinas_id_seq', 8, true);


--
-- Name: personal_personal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.personal_personal_id_seq', 9, true);


--
-- Name: provedores_provedor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.provedores_provedor_id_seq', 6, true);


--
-- Name: proyectos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.proyectos_id_seq', 3, true);


--
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (cliente_id);


--
-- Name: compra_materiales compra_materiales_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra_materiales
    ADD CONSTRAINT compra_materiales_pkey PRIMARY KEY (id);


--
-- Name: compras compras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compras
    ADD CONSTRAINT compras_pkey PRIMARY KEY (id);


--
-- Name: insumos_en_stock insumos_en_stock_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insumos_en_stock
    ADD CONSTRAINT insumos_en_stock_pkey PRIMARY KEY (material_id);


--
-- Name: insumos_en_stock insumos_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.insumos_en_stock
    ADD CONSTRAINT insumos_unique UNIQUE (nombre);


--
-- Name: mantenimientos mantenimientos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos
    ADD CONSTRAINT mantenimientos_pkey PRIMARY KEY (id);


--
-- Name: maquina_insumos maquina_insumos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maquina_insumos
    ADD CONSTRAINT maquina_insumos_pkey PRIMARY KEY (id);


--
-- Name: maquinas maquinas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maquinas
    ADD CONSTRAINT maquinas_pkey PRIMARY KEY (id);


--
-- Name: clientes nombre_personal_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT nombre_personal_key UNIQUE (nombre);


--
-- Name: provedores nombre_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provedores
    ADD CONSTRAINT nombre_unique UNIQUE (nombre);


--
-- Name: personal personal_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal
    ADD CONSTRAINT personal_email_key UNIQUE (email);


--
-- Name: personal personal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal
    ADD CONSTRAINT personal_pkey PRIMARY KEY (personal_id);


--
-- Name: provedores provedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.provedores
    ADD CONSTRAINT provedores_pkey PRIMARY KEY (provedor_id);


--
-- Name: proyectos proyectos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proyectos
    ADD CONSTRAINT proyectos_pkey PRIMARY KEY (id);


--
-- Name: vista_maquinas _RETURN; Type: RULE; Schema: public; Owner: postgres
--

CREATE OR REPLACE VIEW public.vista_maquinas AS
 SELECT maquinas.id,
    maquinas.nombre,
    count(maquina_insumos.maquina) AS materiales,
    maquinas.proporcion,
    maquinas.activo
   FROM (public.maquinas
     LEFT JOIN public.maquina_insumos ON ((maquinas.id = maquina_insumos.maquina)))
  GROUP BY maquinas.id
  ORDER BY maquinas.id;


--
-- Name: vista_compras _RETURN; Type: RULE; Schema: public; Owner: postgres
--

CREATE OR REPLACE VIEW public.vista_compras AS
 SELECT compras.id,
    compras.fecha,
    provedores.nombre AS provedor,
    count(compra_materiales.compra) AS materiales
   FROM ((public.compras
     LEFT JOIN public.compra_materiales ON ((compras.id = compra_materiales.compra)))
     JOIN public.provedores ON ((compras.provedor = provedores.provedor_id)))
  GROUP BY compras.id, provedores.provedor_id
  ORDER BY compras.id;


--
-- Name: compra_materiales compra_materiales_compra_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra_materiales
    ADD CONSTRAINT compra_materiales_compra_fkey FOREIGN KEY (compra) REFERENCES public.compras(id);


--
-- Name: compra_materiales compra_materiales_material_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra_materiales
    ADD CONSTRAINT compra_materiales_material_fkey FOREIGN KEY (material) REFERENCES public.insumos_en_stock(material_id);


--
-- Name: compras compras_provedor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compras
    ADD CONSTRAINT compras_provedor_fkey FOREIGN KEY (provedor) REFERENCES public.provedores(provedor_id);


--
-- Name: mantenimientos mantenimientos_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos
    ADD CONSTRAINT mantenimientos_personal_fkey FOREIGN KEY (personal) REFERENCES public.personal(personal_id);


--
-- Name: mantenimientos mantenimientos_proyecto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mantenimientos
    ADD CONSTRAINT mantenimientos_proyecto_fkey FOREIGN KEY (proyecto) REFERENCES public.proyectos(id);


--
-- Name: maquina_insumos maquina_insumos_insumo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maquina_insumos
    ADD CONSTRAINT maquina_insumos_insumo_fkey FOREIGN KEY (insumo) REFERENCES public.insumos_en_stock(material_id);


--
-- Name: maquina_insumos maquina_insumos_maquina_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maquina_insumos
    ADD CONSTRAINT maquina_insumos_maquina_fkey FOREIGN KEY (maquina) REFERENCES public.maquinas(id);


--
-- Name: proyectos proyectos_cliente_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proyectos
    ADD CONSTRAINT proyectos_cliente_id_fkey FOREIGN KEY (cliente_id) REFERENCES public.clientes(cliente_id);


--
-- Name: proyectos proyectos_maquina_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proyectos
    ADD CONSTRAINT proyectos_maquina_id_fkey FOREIGN KEY (maquina_id) REFERENCES public.maquinas(id);


--
-- PostgreSQL database dump complete
--

