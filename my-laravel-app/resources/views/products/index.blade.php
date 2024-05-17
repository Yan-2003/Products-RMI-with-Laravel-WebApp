<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <br><br>
    <h1 style="width: 80%; margin: 0 auto;">Products</h1>
    @if(session('success'))
        <div style="color: green;">
            {{ session('success') }}
        </div>
    @endif
    <br>
    <br>
    <br>
    <table style="width: 80%; margin: 0 auto;">
        <tr style="border: 1px black solid">
            <th style="border: 1px black solid; padding : 30px 20px">Name</th>
            <th style="border: 1px black solid; padding : 30px 20px">Description</th>
            <th style="border: 1px black solid; padding : 30px 20px">Quantity</th>
            <th style="border: 1px black solid; padding : 30px 20px">Retail Price</th>
            <th style="border: 1px black solid; padding : 30px 20px">Store Price</th>
            <th style="border: 1px black solid; padding : 30px 20px">Action</th>
        </tr>
        @foreach($products as $product)
        <tr>
            <td style="border: 1px black solid; padding : 10px">{{ $product->name }}</td>
            <td style="border: 1px black solid; padding : 10px">{{ $product->description }} </td>
            <td style="border: 1px black solid; padding : 10px">{{ $product->quantity }}</td>
            <td style="border: 1px black solid; padding : 10px">{{ $product->retailPrice }}</td>
            <td style="border: 1px black solid; padding : 10px">{{ $product->storePrice }}</td>
            <td style="border: 1px black solid; padding : 10px">
                <form action="{{ route('products.destroy', $product->id) }}" method="POST" style="display:inline;">
                    @csrf
                    @method('DELETE')
                    <button type="submit" style="background-color: red; color: white; border: none; padding: 5px 10px; cursor: pointer;" onclick="return confirm('Are you sure you want to delete this product?');">
                        <i class="fas fa-trash-alt"></i> Delete
                    </button>
                </form>
            </td>
        </tr>
        @endforeach
    </table>
</body>
</html>
