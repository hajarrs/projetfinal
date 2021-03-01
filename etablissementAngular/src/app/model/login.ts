export class Login {
    private _login: string;
    private _password: string;
    

	constructor(login: string='', password: string='') {
		this._login = login;
		this._password = password;
	}

    /**
     * Getter login
     * @return {string}
     */
	public get login(): string {
		return this._login;
	}

    /**
     * Getter password
     * @return {string}
     */
	public get password(): string {
		return this._password;
	}

    /**
     * Setter login
     * @param {string} value
     */
	public set login(value: string) {
		this._login = value;
	}

    /**
     * Setter password
     * @param {string} value
     */
	public set password(value: string) {
		this._password = value;
	}
}
