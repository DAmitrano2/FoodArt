<%@include file="./include/header.jsp"%>
<main class="mt-5 pt-3">
    <div class="container-fluid">
        <div class="row">
        </div>
        <div class="small-container">
          <h2 class="title">Bentornato Amministratore</h2>
        <div id="rowAdmin" class="row justify-content-center">
            <div class="col-md-3 mb-3">
              <div id="adminCard" class="card bg-primary text-white h-100">
                <div class="card-body py-5">Prodotti #count </div>
                <div onclick="hideProductsList()" id="adminCardFooter" class="card-footer d-flex">
                  Vedi i dettagli
                  <span class="ms-auto">
                    <i class="fas fa-chevron-right"></i>
                  </span>
                </div>
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <div id="adminCard" class="card bg-warning text-white h-100">
                <div class="card-body py-5">Utenti #count</div>
                <div onclick="hideUsersList()" id="adminCardFooter" class="card-footer d-flex">
                  Vedi i dettagli
                  <span class="ms-auto">
                    <i class="fas fa-chevron-right"></i>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
       
        <div class="table-container m-3">
        <table id="users" class="table table-striped table-bordered">
          <thead>
              <tr>
                  <th>#ID</th>
                  <th>Profilo</th>
                  <th>Nome</th>
                  <th>Cognome</th>
                  <th>E-mail</th>
                  <th>Rivenditore</th>
                  <th>Azione</th>
              </tr>
          </thead>
          <tbody>
              <tr>
                  <td>1</td>
                  <td><img src="./assets/images/default-user-image.png" width="100%"></td>
                  <td>Alfonso</td>
                  <td>Zappia</td>
                  <td>alfonsozappia00@gmail.com</td>
                  <td>No</td>
                  <td><input type='button' style='width:100%; height:100%;' value='Elimina'></td>
              </tr>
              <tr>
                <td>2</td>
                <td><img src="./assets/images/default-user-image.png" width="100%"></td>
                <td>Davide</td>
                <td>Amitrano</td>
                <td>davideamitrano98@gmail.com</td>
                <td>No</td>
                <td><input type='button' style='width:100%; height:100%;' value='Elimina'></td>
              </tr>
              <tr>
                <td>3</td>
                <td><img src="./assets/images/default-user-image.png" width="100%"></td>
                <td>Donato</td>
                <td>Miranda</td>
                <td>donatomirando93@gmail.com</td>
                <td>No</td>
                <td><input type='button' style='width:100%; height:100%;' value='Elimina'></td>
              </tr>
              <tr>
                <td>4</td>
                <td><img src="./assets/images/default-user-image.png" width="100%"></td>
                <td>Harry</td>
                <td>Potter</td>
                <td>harrypotter98@gmail.com</td>
                <td>No</td>
                <td><input type='button' style='width:100%; height:100%;' value='Elimina'></td>
              </tr>
              <tr>
                <td>5</td>
                <td><img src="./assets/images/default-user-image.png" width="100%"></td>
                <td>Ron</td>
                <td>Weasley</td>
                <td>ronweasley99@gmail.com</td>
                <td>No</td>
                <td><input type='button' style='width:100%; height:100%;' value='Elimina'></td>
              </tr>
          </tbody>
      </table>
    </div>

      <table id="products" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>#ID</th>
                <th>Foto</th>
                <th>Titolo</th>
                <th>Categoria</th>
                <th>Prezzo</th>
                <th>Unit&#224; di misura</th>
                <th>Qt. Disponibile</th>
                <th>Qt. Minima</th>
                <th>Provenienza</th>
                <th>Azione</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td><img src="./assets/images/default-user-image.png" width="100%"></td>
                <td>Confettura di Albiccoche</td>
                <td>Frutta & Verdura</td>
                <td>6 &#8364;</td>
                <td>pezzo</td>
                <td>5</td>
                <td>1</td>
                <td>Pontecagnano Faiano, SA</td>
                <td><input type='button' style='width:100%; height:100%;' value='Elimina'></td>
            </tr>
            <tr>
              <td>2</td>
                <td><img src="./assets/images/default-user-image.png" width="100%"></td>
                <td>Salame Toscano</td>
                <td>Carne</td>
                <td>11.5 &#8364;</td>
                <td>pezzo</td>
                <td>6</td>
                <td>1</td>
                <td>Grosseto, GR</td>
                <td><input type='button' style='width:100%; height:100%;' value='Elimina'></td>
            </tr>
        </tbody>
    </table>
        
    </div>
</main>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>
<script src="<%=path%>/assets/js/admin_dashboard.js"></script>