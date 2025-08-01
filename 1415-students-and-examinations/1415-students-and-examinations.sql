-- In standard SQL, every selected column that isn't part of an aggregate function must appear in the GROUP BY clause. Otherwise, the query will:

-- Throw an error in strict SQL modes (e.g., PostgreSQL, SQL Server, or MySQL with ONLY_FULL_GROUP_BY enabled)

select Students.student_id, Students.student_name, Subjects.subject_name, count(Examinations.subject_name) as attended_exams
from
    Students
cross join 
    Subjects
left join 
    Examinations
    on Students.student_id = Examinations.student_id
    and Subjects.subject_name = Examinations.subject_name
group by 
    Students.student_id, Students.student_name, Subjects.subject_name
order by 
    Students.student_id, subject_name;