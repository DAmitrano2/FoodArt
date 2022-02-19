<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="./assets/css/admin_dashboard_style.css">
<main class="mt-5 pt-3">
    <div class="container-fluid">
        <div class="row">
          <!--
            <div class="col-md-12">
                <h4>Bentornato, **Nome Amministratore**</h4>
            </div>
            -->
        </div>
        <div class="small-container">
          <h2 class="title">Bentornato Amministratore</h2>
        <div id="rowAdmin" class="row">
            <div class="col-md-3 mb-3">
              <div id="adminCard" class="card bg-primary text-white h-100">
                <div class="card-body py-5">Rivenditori in attesa <i class="fas fa-circle blink"></i></div>
                <div class="card-footer d-flex">
                  Vedi i dettagli
                  <span class="ms-auto">
                    <i class="fas fa-chevron-right"></i>
                  </span>
                </div>
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <div id="adminCard" class="card bg-warning text-white h-100">
                <div class="card-body py-5">Recensioni in attesa <i class="fas fa-circle blink"></i></div>
                <div class="card-footer d-flex">
                  Vedi i dettagli
                  <span class="ms-auto">
                    <i class="fas fa-chevron-right"></i>
                  </span>
                </div>
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <div id="adminCard" class="card bg-success text-white h-100">
                <div class="card-body py-5">Prodotti in attesa <i class="fas fa-circle blink"></i></div>
                <div class="card-footer d-flex">
                  Vedi i dettagli
                  <span class="ms-auto">
                    <i class="fas fa-chevron-right"></i>
                  </span>
                </div>
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <div id="adminCard" class="card bg-danger text-white h-100">
                <div class="card-body py-5">Utenti Sospesi <i class="fas fa-circle blink"></i></div>
                <div class="card-footer d-flex">
                  Vedi i dettagli
                  <span class="ms-auto">
                    <i class="fas fa-chevron-right"></i>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
    </div>
</main>
<%@include file="../include/footer.html"%>
<%@include file="../include/script.jsp"%>