INSERT INTO public.ba_faculty(name) VALUES ('ФИТКБ');
INSERT INTO public.ba_faculty(name) VALUES ('ФРТЭ');
INSERT INTO public.ba_faculty(name) VALUES ('ФЭСУ');

INSERT INTO public.ba_direction(name, faculty_id)VALUES ('САПРИС', 1);
INSERT INTO public.ba_direction(name, faculty_id)VALUES ('АВС', 1);
INSERT INTO public.ba_direction(name, faculty_id)VALUES ('КИТП', 1);

INSERT INTO public.ba_study_group(name, direction_id)VALUES ('МРИС-191', 2);