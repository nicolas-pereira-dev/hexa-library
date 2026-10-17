import { OrderStatusEnum } from "./orderStatusEnum";
import { Product } from "./product";

export interface Order {
    id?: number;
    userId: number;
    books:Array<Product>;
    timestamp: string;
    orderStatus?: OrderStatusEnum;
}