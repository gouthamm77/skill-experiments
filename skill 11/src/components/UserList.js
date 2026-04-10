import React,{useEffect,useState} from "react";
export default function UserList(){
const [users,setUsers]=useState([]);
useEffect(()=>{
fetch("https://jsonplaceholder.typicode.com/users")
.then(res=>res.json()).then(setUsers);
},[]);
return(<div><h3>Users API</h3>
{users.map(u=><p key={u.id}>{u.name}-{u.email}</p>)}
</div>);
}
