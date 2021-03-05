export class Login {
    private _login: string;
    private _password: string;
    private _premiereConnexion: boolean;
    private _typeUtilisateur: string;
    

	constructor(login: string='', password: string='', premiereConnexion:boolean=true, typeUtilisateur:string='') {
		this._login = login;
		this._password = password;
        this._premiereConnexion=premiereConnexion;
        this._typeUtilisateur=typeUtilisateur;
	}


    /**
     * Getter premiereConnexion
     * @return {boolean}
     */
	public get premiereConnexion(): boolean {
		return this._premiereConnexion;
	}

    /**
     * Getter typeUtilisateur
     * @return {string}
     */
	public get typeUtilisateur(): string {
		return this._typeUtilisateur;
	}

    /**
     * Setter premiereConnexion
     * @param {boolean} value
     */
	public set premiereConnexion(value: boolean) {
		this._premiereConnexion = value;
	}

    /**
     * Setter typeUtilisateur
     * @param {string} value
     */
	public set typeUtilisateur(value: string) {
		this._typeUtilisateur = value;
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
