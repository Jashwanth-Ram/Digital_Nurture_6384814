import { Component } from "react";
export class Cart extends Component {
    render() {
        return (
            <table className="cart-table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {this.props.item.map(item => (
                        <tr>
                            <td>{item.itemname}</td>
                            <td>{item.price}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        );
    }
}