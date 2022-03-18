	export class User {
        constructor(public username: string, public password: string, public role: string, public email: string, public lastlogin: Date, public langueId: string, public langue: string)
	{
		this.username = this.username;
		this.password = this.password;
		this.role = this.role;
		this.lastlogin = this.lastlogin;
		this.email = this.email;
        this.langue= this.langue;
		this.langueId = this.langueId;
	}
}