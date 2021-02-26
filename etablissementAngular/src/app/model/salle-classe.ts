import { Matiere } from "./matiere";

export class SalleClasse {
    private _id: number;
    private _nom: string;
    private _matieresExclues: Matiere;
    private _matieres: Matiere[] = [];
    private _capacite: number;


	constructor(id: number, nom: string, matieresExclues: Matiere, matieres: Matiere[] , capacite: number) {
		this._id = id;
		this._nom = nom;
		this._matieresExclues = matieresExclues;
		this._matieres = matieres;
		this._capacite = capacite;
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
     * Getter matieresExclues
     * @return {Matiere}
     */
	public get matieresExclues(): Matiere {
		return this._matieresExclues;
	}

    /**
     * Getter matieres
     * @return {Matiere[] }
     */
	public get matieres(): Matiere[]  {
		return this._matieres;
	}

    /**
     * Getter capacite
     * @return {number}
     */
	public get capacite(): number {
		return this._capacite;
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
     * Setter matieresExclues
     * @param {Matiere} value
     */
	public set matieresExclues(value: Matiere) {
		this._matieresExclues = value;
	}

    /**
     * Setter matieres
     * @param {Matiere[] } value
     */
	public set matieres(value: Matiere[] ) {
		this._matieres = value;
	}

    /**
     * Setter capacite
     * @param {number} value
     */
	public set capacite(value: number) {
		this._capacite = value;
	}


}
