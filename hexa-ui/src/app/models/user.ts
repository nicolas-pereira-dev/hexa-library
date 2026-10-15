export class User {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    role: string;

    constructor(id?: number, username?: string, password?: string, firstName?: string, lastName?: string, email?: string, role?: string) {
        this.id = id ? id : -1;
        this.username = username ? username : '';
        this.password = password ? password : '';
        this.firstName = firstName ? firstName : '';
        this.lastName = lastName ? lastName : '';
        this.email = email ? email : '';
        this.role = role ? role : '';
    }
}