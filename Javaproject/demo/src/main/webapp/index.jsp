<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Distance Calculator</title>
</head>
<body>

<h2>Haversine Calculator</h2>

<form method="post">
    Lat1: <input type="text" name="lat1"><br><br>
    Lon1: <input type="text" name="lon1"><br><br>
    Lat2: <input type="text" name="lat2"><br><br>
    Lon2: <input type="text" name="lon2"><br><br>

    <input type="submit" value="Calculate">
</form>

<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        try {
            double lat1 = Double.parseDouble(request.getParameter("lat1"));
            double lon1 = Double.parseDouble(request.getParameter("lon1"));
            double lat2 = Double.parseDouble(request.getParameter("lat2"));
            double lon2 = Double.parseDouble(request.getParameter("lon2"));

            double R = 6371e3;

            double phi1 = Math.toRadians(lat1);
            double phi2 = Math.toRadians(lat2);
            double dPhi = Math.toRadians(lat2 - lat1);
            double dLambda = Math.toRadians(lon2 - lon1);

            double a = Math.sin(dPhi/2)*Math.sin(dPhi/2) +
                       Math.cos(phi1)*Math.cos(phi2) *
                       Math.sin(dLambda/2)*Math.sin(dLambda/2);

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

            double distance = R * c;

            out.println("<h3>Distance: " + String.format("%.2f", distance) + " m</h3>");

        } catch (Exception e) {
            out.println("<h3>Invalid input!</h3>");
        }
    }
%>

</body>
</html>