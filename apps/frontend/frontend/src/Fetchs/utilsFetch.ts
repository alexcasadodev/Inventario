import type { UserInsertDTO, UserLogin } from "../Interfaces/Interfaces";


const httpServer = `http://localhost:8080`

export async function createUser (userInsertDTO: UserInsertDTO) {
    const response = await fetch (`${httpServer}/backend/users/createUser`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(userInsertDTO)
    });

    if (!response.ok) {
        const errorText = await response.text();
        throw new Error(errorText || "Api error");
    }

    return response;
}

export async function login(credenciales: UserLogin) {
    const response = await fetch(`${httpServer}/backend/users/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(credenciales)
    });

    if (!response.ok) {
        const errorText = await response.text();
        throw new Error(errorText || "Api error");
    }

    return response;
    
}