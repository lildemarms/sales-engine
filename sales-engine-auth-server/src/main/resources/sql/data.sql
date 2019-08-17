DELETE FROM public.oauth_client_details;

INSERT INTO public.sys_user (username, email, password, activated)
SELECT * FROM (SELECT 'admin', 'admin@admin.com', '$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy', true) AS tmp
WHERE NOT EXISTS (
    SELECT username FROM public.sys_user WHERE username = 'admin'
) LIMIT 1;

INSERT INTO public.authority (name)
SELECT * FROM (SELECT 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM public.authority WHERE name = 'ROLE_USER'
) LIMIT 1;

INSERT INTO public.authority (name)
SELECT * FROM (SELECT 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM public.authority WHERE name = 'ROLE_ADMIN'
) LIMIT 1;

INSERT INTO public.user_authority (username, authority)
SELECT * FROM (SELECT 'admin', 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM public.user_authority WHERE username = 'admin' and authority = 'ROLE_USER'
) LIMIT 1;

INSERT INTO public.user_authority (username, authority)
SELECT * FROM (SELECT 'admin', 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT username, authority FROM public.user_authority WHERE username = 'admin' and authority = 'ROLE_ADMIN'
) LIMIT 1;