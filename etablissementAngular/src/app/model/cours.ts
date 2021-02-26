import { Matiere } from "./matiere";
import { Professeur } from "./professeur";
import { SalleClasse } from "./salle-classe";

export class Cours {

private _id: number;
private _heureDebut: string;
private _heureFin: string;
private _professeur: Professeur;
private _matiere: Matiere
private _salle: SalleClasse;


	constructor(id: number, heureDebut: string , heureFin: string, professeur: Professeur, matiere: Matiere, salle: SalleClasse) {
		this._id = id;
		
		this._heureDebut = heureDebut;
		this._heureFin = heureFin;
		this._professeur = professeur;
		this._matiere = matiere;
		this._salle = salle;
	}


    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter heureDebut
     * @return {string}
     */
	public get heureDebut(): string {
		return this._heureDebut;
	}

    /**
     * Getter heureFin
     * @return {string}
     */
	public get heureFin(): string {
		return this._heureFin;
	}

    /**
     * Getter professeur
     * @return {Professeur}
     */
	public get professeur(): Professeur {
		return this._professeur;
	}

    /**
     * Getter matiere
     * @return {Matiere}
     */
	public get matiere(): Matiere {
		return this._matiere;
	}

    /**
     * Getter salle
     * @return {SalleClasse}
     */
	public get salle(): SalleClasse {
		return this._salle;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter heureDebut
     * @param {string} value
     */
	public set heureDebut(value: string) {
		this._heureDebut = value;
	}

    /**
     * Setter heureFin
     * @param {string} value
     */
	public set heureFin(value: string) {
		this._heureFin = value;
	}

    /**
     * Setter professeur
     * @param {Professeur} value
     */
	public set professeur(value: Professeur) {
		this._professeur = value;
	}

    /**
     * Setter matiere
     * @param {Matiere} value
     */
	public set matiere(value: Matiere) {
		this._matiere = value;
	}

    /**
     * Setter salle
     * @param {SalleClasse} value
     */
	public set salle(value: SalleClasse) {
		this._salle = value;
	}


}
