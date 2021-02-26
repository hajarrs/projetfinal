import { Adresse } from "./adresse";
import { Etablissement } from "./etablissement";
import { Login } from "./login";

export class Utilisateur {
    private _id!: number;
    private _login!: Login;
    private _nom: string;
    private _prenom: string;
    private _adresse!: Adresse;
    private _dateNaissance: string;
    private _etablissement!: Etablissement;


	constructor(id?: number, login?: Login, nom: string='', prenom: string='', adresse?: Adresse, dateNaissance: string='', etablissement?: Etablissement) {
		
		
		this._nom = nom;
		this._prenom = prenom;
		this._dateNaissance = dateNaissance;
		
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
     * @return {Login}
     */
	public get login(): Login {
		return this._login;
	}

    /**
     * Getter nom
     * @return {string}
     */
	public get nom(): string {
		return this._nom;
	}

    /**
     * Getter prenom
     * @return {string}
     */
	public get prenom(): string {
		return this._prenom;
	}

    /**
     * Getter adresse
     * @return {Adresse}
     */
	public get adresse(): Adresse {
		return this._adresse;
	}

    /**
     * Getter dateNaissance
     * @return {string}
     */
	public get dateNaissance(): string {
		return this._dateNaissance;
	}

    /**
     * Getter etablissement
     * @return {Etablissement}
     */
	public get etablissement(): Etablissement {
		return this._etablissement;
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
     * @param {Login} value
     */
	public set login(value: Login) {
		this._login = value;
	}

    /**
     * Setter nom
     * @param {string} value
     */
	public set nom(value: string) {
		this._nom = value;
	}

    /**
     * Setter prenom
     * @param {string} value
     */
	public set prenom(value: string) {
		this._prenom = value;
	}

    /**
     * Setter adresse
     * @param {Adresse} value
     */
	public set adresse(value: Adresse) {
		this._adresse = value;
	}

    /**
     * Setter dateNaissance
     * @param {string} value
     */
	public set dateNaissance(value: string) {
		this._dateNaissance = value;
	}

    /**
     * Setter etablissement
     * @param {Etablissement} value
     */
	public set etablissement(value: Etablissement) {
		this._etablissement = value;
	}



}
