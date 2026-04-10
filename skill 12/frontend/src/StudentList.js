import React,{useState,useEffect} from "react";
import axios from "axios";

export default function StudentList(){
const [students,setStudents]=useState([]);
const [name,setName]=useState("");

useEffect(()=>{fetchData();},[]);

const fetchData=()=>{
axios.get("http://localhost:8083/students")
.then(res=>setStudents(res.data));
};

const add=()=>{
axios.post("http://localhost:8083/students",{id:Date.now(),name})
.then(fetchData);
};

const del=(id)=>{
axios.delete("http://localhost:8083/students/"+id)
.then(fetchData);
};

return(
<div>
<h2>Students</h2>
<input value={name} onChange={e=>setName(e.target.value)} placeholder="Name"/>
<button onClick={add}>Add</button>
<ul>
{students.map(s=>(
<li key={s.id}>{s.name}
<button onClick={()=>del(s.id)}>Delete</button>
</li>
))}
</ul>
</div>
);
}