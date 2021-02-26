export class Login {
    private _id: number;
    private _login: string;
    private _password: string;
    private _premiereConnexione: boolean;
    

	constructor(id: number, login: string, password: string, premiereConnexione: boolean) {
		this._id = id;
		this._login = login;
		this._password = password;
		this._premiereConnexione = premiereConnexione;
	}


    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
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
     * Getter premiereConnexione
     * @return {boolean}
     */
	public get premiereConnexione(): boolean {
		return this._premiereConnexione;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
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

    /**
     * Setter premiereConnexione
     * @param {boolean} value
     */
	public set premiereConnexione(value: boolean) {
		this._premiereConnexione = value;
	}


}
