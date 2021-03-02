import { Professeur } from "./professeur";

export class GroupeClasse {
    //! => undefined
    private _id!: number;
    private _nom: string;
    private _professeurPrincipal!: Professeur;


	constructor(id?: number, nom: string='', professeurPrincipal?: Professeur) {

		this._nom = nom;

	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}
    /**
     * Getter nom
     * @return {string}
     */
	public get nom(): string {
		return this._nom;
	}
    /**
     * Setter id
     * @param {number} value
     */
    public set id(value: number) {
      this._id = value;
    }
    /**
     * Setter nom
     * @param {string} value
     */
	public set nom(value: string) {
		this._nom = value;
	}
 /**
     * Getter professeurPrincipal
     * @return {Professeur}
     */
	public get professeurPrincipal(): Professeur {
		return this._professeurPrincipal;
	}

    /**
     * Setter nom
     * @param {Professeur} value
     */
	public set professeurPrincipal(value: Professeur) {
		this._professeurPrincipal = value;
	}

}
