import React,{useEffect,useState} from "react";
export default function LocalUserList(){
const [users,setUsers]=useState([]);
useEffect(()=>{
fetch("/users.json").then(res=>res.json()).then(setUsers);
},[]);
return(<div><h3>Local Users</h3>
{users.map(u=><p key={u.id}>{u.name}-{u.email}</p>)}
</div>);
}
