export interface UserInsertDTO {
    nombre: string,
    email: string,
    contraseña: string,
    rol: string
}

export interface UserLogin {
    username: string,
    password: string
}