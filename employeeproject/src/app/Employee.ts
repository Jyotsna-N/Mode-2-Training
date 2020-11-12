import { skill } from 'src/skill';

export interface  Employee{
    id:number;
    name:string;
    salary:number;
    permanent:string;
    skill:skill[];
    dob:string;
    department_id:number;
    department_name:string;
}