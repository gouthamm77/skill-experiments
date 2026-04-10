import React,{useState} from "react";
import axios from "axios";

export default function Login(){
const [user,setUser]=useState({username:"",password:""});

const login=()=>{
axios.post("http://localhost:8084/login",user)
.then(res=>alert("Welcome "+res.data.username));
};

return(
<div>
<h2>Login</h2>
<input placeholder="Username" onChange={e=>setUser({...user,username:e.target.value})}/>
<input placeholder="Password" onChange={e=>setUser({...user,password:e.target.value})}/>
<button onClick={login}>Login</button>
</div>
);
}
