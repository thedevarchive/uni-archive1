<html>
    <body>
        <table style="width:25%">
			<tr>
				<th>Products</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Subtotal</th>
			</tr>
			<tr>
				<td><center>Product A</center></td>
				<td><center>10</center></td>
				<td><center><?php echo $_POST['multA']; ?></center></td>
				<td><center><?php echo $_POST['hiddenA']; ?></center></td>
			</tr>
			<tr>
				<td><center>Product B</center></td>
				<td><center>15</center></td>
				<td><center><?php echo $_POST['multB']; ?></center></td>
				<td><center><?php echo $_POST['hiddenB']; ?></center></td>
			</tr>
			<tr>
				<td><center>Product C</center></td>
				<td><center>20</center></td>
				<td><center><?php echo $_POST['multC']; ?></center></td>
				<td><center><?php echo $_POST['hiddenC']; ?></center></td>
			</tr>
			<tr>
				<td></td>
				<td><center>Total</center></td>
				<td><center><?php echo $_POST['hiddenTot']; ?></center></td>
				<td><center><?php echo $_POST['hiddenTP']; ?></center></td>
			</tr>
    </body>
</html>