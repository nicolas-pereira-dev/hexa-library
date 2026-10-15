import { Product } from "./product";

export interface Order {
    id?: number;
    userId: number;
    books:Array<Product>;
    timestamp: string;
}