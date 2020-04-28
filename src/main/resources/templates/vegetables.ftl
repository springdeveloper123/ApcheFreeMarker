<!DOCTYPE html>
<html lang="en">
<head>
	<style>
		table, th, td {
		  border: 1px solid black;
		  border-collapse: collapse;
		}
		th, td {
		  padding: 5px;
		  text-align: left;
		}
	</style>
</head>
<body>
    <h2>${title}</h2>
    <table>
    	<tr>
    		<th>Name</th>
    		<th>Price</th>
    	</tr>
    	<#list vals as val>
    		<tr>
    			<td>${val.name}</td>
    			<#if ${val.price}>
    				<td>${val.price}</td>
    			<#else>
    				<td></td>
    			</#if> 
    		</tr>
    	</#list>
    </table>
</body>
</html>