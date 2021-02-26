import { Adresse } from "./adresse";

export class Etablissement {
    private _id: number;
    private _nom: string;
    private _adresse: Adresse;
    private _numTel: string;
    private _image: string;


	constructor(id: number, nom: string, adresse: Adresse, numTel: string, image: string) {
		this._id = id;
		this._nom = nom;
		this._adresse = adresse;
		this._numTel = numTel;
		this._image = image;
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
     * Getter adresse
     * @return {Adresse}
     */
	public get adresse(): Adresse {
		return this._adresse;
	}

    /**
     * Getter numTel
     * @return {string}
     */
	public get numTel(): string {
		return this._numTel;
	}

    /**
     * Getter image
     * @return {string}
     */
	public get image(): string {
		return this._image;
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
     * Setter adresse
     * @param {Adresse} value
     */
	public set adresse(value: Adresse) {
		this._adresse = value;
	}

    /**
     * Setter numTel
     * @param {string} value
     */
	public set numTel(value: string) {
		this._numTel = value;
	}

    /**
     * Setter image
     * @param {string} value
     */
	public set image(value: string) {
		this._image = value;
	}



}
