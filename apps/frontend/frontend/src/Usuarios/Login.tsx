import { useEffect, useState } from "react";
import { login } from "../Fetchs/utilsFetch";
import type { UserLogin } from "../Interfaces/Interfaces";

export const Login = ()=>{

    // Estados para input username and password
    const [username, setUsername] = useState("");

    const [password, setPassword] = useState("");

    // useEffect(()=> {
    //     console.log("username", username)
    // }, [username])

    // useEffect(()=> {
    //     console.log("password", password)
    // }, [password])

    async function funcionlogin(username:string, password:string): Promise<void> {

        const credenciales: UserLogin = {
            username: username,
            password: password
        }

        const response = await login(credenciales)
        console.log("response", response)
    }



    return (
        <div className="w-full h-screen bg-gradient-to-br from-slate-900 via-indigo-900 to-purple-900 flex items-center justify-center">
            
            <div className="w-80 h-112 backdrop-blur-lg rounded-xl border border-white/20 shadow-xl flex flex-col justify-center" >

                <h2 className="text-white text-xl font-demibold text-center">Login</h2>

                <input 
                    placeholder="Username"
                    type="text" 
                    onChange={(e) => {
                        setUsername(e.target.value)
                    }}
                />

                <input
                    placeholder="Password" 
                    type="password" 
                    onChange={(e) => {
                        setPassword(e.target.value)
                    }}
                />

               <button
                type="button"
                onClick={(e) => {
                    funcionlogin(username, password)
                }}
                // className="rounded-xl border border-white"
               >
                Acceder
               </button>
            
            </div>
        </div>
    );
};