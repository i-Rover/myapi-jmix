CREATE OR REPLACE PROCEDURE public.update_work_program(IN work_program_type character varying)
 LANGUAGE plpgsql
AS $procedure$
	BEGIN
	update work_program
	set work_program = 'Transport Palm Oil'
	where work_program = work_program_type;
	END;
$procedure$
;
