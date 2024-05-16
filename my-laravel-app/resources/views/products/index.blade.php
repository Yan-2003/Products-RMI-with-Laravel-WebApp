<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="{{ asset('css/app.css') }}">
</head>
<body>
    <h1>Products</h1>
    @if(session('success'))
        <div style="color: green;">
            {{ session('success') }}
        </div>
    @endif
    <ul>
        @foreach($products as $product)
            <li>
                {{ $product->name }} - {{ $product->description }} - {{ $product->quantity }} - {{ $product->retailPrice }} - {{ $product->storePrice }}
                <form action="{{ route('products.destroy', $product->id) }}" method="POST" style="display:inline;">
                    @csrf
                    @method('DELETE')
                    <button type="submit" style="background-color: red; color: white; border: none; padding: 5px 10px; cursor: pointer;" onclick="return confirm('Are you sure you want to delete this product?');">
                        <i class="fas fa-trash-alt"></i> Delete
                    </button>
                </form>
            </li>
        @endforeach
    </ul>
</body>
</html>
