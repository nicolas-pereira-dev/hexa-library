import { RoleEnum } from "./RoleEnum";

export class User {
    id: number;
    username: string;
    password: string;
    firstName?: string;
    lastName?: string;
    email?: string;
    role?: RoleEnum;

    constructor(id?: number, username?: string, password?: string, firstName?: string, lastName?: string, email?: string, role?: RoleEnum) {
        this.id = id ? id : -1;
        this.username = username ? username : '';
        this.password = password ? password : '';
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }
}