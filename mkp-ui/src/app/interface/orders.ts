export interface Orders {
    id: string;
    name: string;
    totalAmount?: number;
    orderDetails:OrderDetail[];
}
  
export interface OrderDetail {
    productId: string;
    productName?: string;
    price?: number;
}