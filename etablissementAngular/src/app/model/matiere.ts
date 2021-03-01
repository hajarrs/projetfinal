export class Matiere {
private _id!: number;
private _nom: string;
private _couleur: string;


	constructor(id?: number, nom: string='', couleur: string='') {
		this._nom = nom;
		this._couleur = couleur;
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
     * Getter couleur
     * @return {string}
     */
	public get couleur(): string {
		return this._couleur;
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
     * Setter couleur
     * @param {string} value
     */
	public set couleur(value: string) {
		this._couleur = value;
	}






}
