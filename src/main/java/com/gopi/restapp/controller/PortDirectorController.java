package com.gopi.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.restapp.model.Invoice;
import com.gopi.restapp.model.LogisticManager;
import com.gopi.restapp.model.OperationManager;
import com.gopi.restapp.model.Ship;
import com.gopi.restapp.model.VesselOperator;
import com.gopi.restapp.service.InvoiceService;
import com.gopi.restapp.service.LogisticManagerService;
import com.gopi.restapp.service.OperationManagerService;
import com.gopi.restapp.service.ShipService;
import com.gopi.restapp.service.VesselOperatorService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/portDirector")
public class PortDirectorController {

	@Autowired
	private ShipService shipService;

	@Autowired
	private LogisticManagerService logisticManagerService;

	@Autowired
	private OperationManagerService operationManagerService;

//	@Autowired
//	private PortDirectorService portDirectorService;
	
	@Autowired
	private VesselOperatorService vesselOperatorService;

	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/ship/currentStage/{shipId}")
    public Integer getCurrentStage(@PathVariable Long shipId) {
        Ship ship = shipService.getShipById(shipId);

        int currentStage = 1; // Default to 'Requested'

        if ("requested".equalsIgnoreCase(ship.getRequest())) {
            currentStage = 2; // 'Pending' stage
        } else if ("Accepted".equalsIgnoreCase(ship.getRequest())) {
            currentStage = 4; // 'Waiting for Berth' stage
        }
        String berth = ship.getBerth();
        if (berth != null && !"".equalsIgnoreCase(berth)) {
            currentStage = 5; // 'Berth Allocated' stage
        }

        return currentStage;
    }


	@GetMapping("/ship/all")
	public List<Ship> getAllShips() {
		return shipService.getAllShips();
	}

	@GetMapping("/ship/ids")
	public List<Long> getAllShipsIds() {
		return shipService.getAllShipsIds();
	}
	
	@GetMapping("/ship/shipnames")
	public List<String> getAllShipsNAmes() {
		return shipService.getAllShipsNames();
	}

	@GetMapping("/ship/{id}")
	public Ship getShipById(@PathVariable Long id) {
		return shipService.getShipById(id);
	}
	
	@GetMapping("/shipName/{shipName}")
	public Ship getShipByShipName(@PathVariable String shipName) {
		return shipService.getShipByShipName(shipName);
	}
	
	@GetMapping("/ship/imoNumber/{imoNumber}")
	public Ship getImoNumberId(@PathVariable int imoNumber) {
		return shipService.getShipByImoNumber(imoNumber);
	}
	

	@PostMapping("/ship")
	public Ship createShip(@RequestBody Ship Ship) {
		shipService.saveShip(Ship);
		return Ship;
	}

	@PutMapping("/ship/{id}")
	public Ship updateShip(@PathVariable Long id, @RequestBody Ship Ship) {
		Ship.setShipId(id);
		shipService.updateShip(id, Ship);
		return Ship;
	}

	@DeleteMapping("/ship/{id}")
	public void deleteShip(@PathVariable Long id) {
		shipService.deleteShipById(id);
	}
	
	@GetMapping("/getshipbyvesselOperator/{vesselOperatorId}")
    public ResponseEntity<List<Ship>> getShipsByVesselOperatorId(@PathVariable int vesselOperatorId) {
        List<Ship> ships = shipService.getShipsByVesselOperatorId(vesselOperatorId);
        if (ships.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ships);
    }

//    -----------------

	@GetMapping("/logisticManager/all")
	public List<LogisticManager> getAllLogisticManagers() {
		return logisticManagerService.getAllLogisticManagers();
	}

	@GetMapping("/logisticManager/{id}")
	public LogisticManager getLogisticManagerById(@PathVariable int id) {
		return logisticManagerService.getLogisticManagerById(id);
	}

	@PostMapping("/logisticManager")
	public LogisticManager createLogisticManager(@RequestBody LogisticManager LogisticManager) {
		logisticManagerService.saveLogisticManager(LogisticManager);
		return LogisticManager;
	}

	@PutMapping("/logisticManager/{id}")
	public LogisticManager updateLogisticManager(@PathVariable int id, @RequestBody LogisticManager LogisticManager) {
		LogisticManager.setLogisticManagerId(id);
		logisticManagerService.updateLogisticManager(id, LogisticManager);
		return LogisticManager;
	}

	@DeleteMapping("/logisticManager/{id}")
	public void deleteLogisticManager(@PathVariable int id) {
		logisticManagerService.deleteLogisticManagerById(id);
	}

//    ----------------

	@GetMapping("/vesselOperator/all")
	public List<VesselOperator> getAllVesselOperators() {
		return vesselOperatorService.getAllVesselOperators();
	}

	@GetMapping("/vesselOperator/{id}")
	public VesselOperator getVesselOperatorById(@PathVariable int id) {
		return vesselOperatorService.getVesselOperatorById(id);
	}

	@PostMapping("/vesselOperator")
	public VesselOperator createVesselOperator(@RequestBody VesselOperator VesselOperator) {
		vesselOperatorService.saveVesselOperator(VesselOperator);
		return VesselOperator;
	}

	@PutMapping("/vesselOperator/{id}")
	public VesselOperator updateVesselOperator(@PathVariable int id, @RequestBody VesselOperator VesselOperator) {
		VesselOperator.setVesselOperatorId(id);
		vesselOperatorService.updateVesselOperator(id, VesselOperator);
		return VesselOperator;
	}

	@DeleteMapping("/vesselOperator/{id}")
	public void deleteVesselOperator(@PathVariable int id) {
		vesselOperatorService.deleteVesselOperatorById(id);
	}

//    ------------------
	@GetMapping("/operationManager/all")
	public List<OperationManager> getAllOperationManagers() {
		return operationManagerService.getAllOperationManagers();
	}

	@GetMapping("/operationManager/{id}")
	public OperationManager getOperationManagerById(@PathVariable int id) {
		return operationManagerService.getOperationManagerById(id);
	}

	@PostMapping("/operationManager")
	public OperationManager createOperationManager(@RequestBody OperationManager OperationManager) {
		operationManagerService.saveOperationManager(OperationManager);
		return OperationManager;
	}

	@PutMapping("/operationManager/{id}")
	public OperationManager updateOperationManager(@PathVariable int id,
			@RequestBody OperationManager OperationManager) {
		OperationManager.setOperationManagerId(id);
		operationManagerService.updateOperationManager(id, OperationManager);
		return OperationManager;
	}

	@DeleteMapping("/operationManager/{id}")
	public void deleteOperationManager(@PathVariable int id) {
		operationManagerService.deleteOperationManagerById(id);
	}

//    --------------

//    ------------------------

	@GetMapping("/invoice/all")
	public List<Invoice> getAllInvoices() {
		return invoiceService.getAllInvoices();
	}

	@GetMapping("/invoice/{id}")
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}

	@PostMapping("/invoice")
	public Invoice createInvoice(@RequestBody Invoice Invoice) {
		invoiceService.saveInvoice(Invoice);
		return Invoice;
	}

	@PutMapping("/invoice/{id}")
	public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice Invoice) {
		Invoice.setInvoiceId(id);
		invoiceService.updateInvoice(id, Invoice);
		return Invoice;
	}

	@DeleteMapping("/invoice/{id}")
	public void deleteInvoice(@PathVariable Long id) {
		invoiceService.deleteInvoiceById(id);
	}
	
//	--------------------------------
	
//	@GetMapping("/portDirector/all")
//	public List<PortDirector> getAllPortDirectors() {
//		return portDirectorService.getAllPortDirectors();
//	}
//
//	@GetMapping("/portDirector/{id}")
//	public PortDirector getPortDirectorById(@PathVariable int id) {
//		return portDirectorService.getPortDirectorById(id);
//	}
//
//	@PostMapping("/portDirector")
//	public PortDirector createPortDirector(@RequestBody PortDirector PortDirector) {
//		portDirectorService.savePortDirector(PortDirector);
//		return PortDirector;
//	}
//
//	@PutMapping("/portDirector/{id}")
//	public PortDirector updatePortDirector(@PathVariable int id, @RequestBody PortDirector PortDirector) {
//		PortDirector.setPortDirectorId(id);
//		portDirectorService.updatePortDirector(id, PortDirector);
//		return PortDirector;
//	}
//
//	@DeleteMapping("/portDirector/{id}")
//	public void deletePortDirector(@PathVariable int id) {
//		portDirectorService.deletePortDirectorById(id);
//	}
	
	
	
//	@PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestBody Login login) {
//        String userName = login.getUserName();
//        String password = login.getPassword();
//
//        // Authenticate LogisticManager
//        LogisticManager logisticManager = logisticManagerService.getLogisticManagerByUserName(userName);
//        if (logisticManager != null) {
//            if (logisticManager.getPassword().equals(password)) {
//                if (logisticManager.isPasswordExpired()) {
//                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("PASSWORD_UPDATE_REQUIRED");
//                }
//                return ResponseEntity.ok(logisticManager);
//            }
//        }
//
//        // Authenticate VesselOperator
//        VesselOperator vesselOperator = vesselOperatorService.getVesselOperatorByUserName(userName);
//        if (vesselOperator != null) {
//            if (vesselOperator.getPassword().equals(password)) {
//                if (vesselOperator.isPasswordExpired()) {
//                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("PASSWORD_UPDATE_REQUIRED");
//                }
//                return ResponseEntity.ok(vesselOperator);
//            }
//        }
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//    }
//
//    @PostMapping("/updatePassword")
//    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request) {
//        String userName = request.getUserName();
//        String newPassword = request.getNewPassword();
//
//        // Update password logic
//        LogisticManager logisticManager = logisticManagerService.getLogisticManagerByUserName(userName);
//        if (logisticManager != null) {
//            logisticManager.setPassword(newPassword);
//            logisticManager.setPasswordExpired(false);
//            logisticManagerService.saveLogisticManager(logisticManager);
//            return ResponseEntity.ok("Password updated successfully");
//        }
//
//        VesselOperator vesselOperator = vesselOperatorService.getVesselOperatorByUserName(userName);
//        if (vesselOperator != null) {
//            vesselOperator.setPassword(newPassword);
//            vesselOperator.setPasswordExpired(false);
//            vesselOperatorService.saveVesselOperator(vesselOperator);
//            return ResponseEntity.ok("Password updated successfully");
//        }
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//    }
    
	
	
	
}
