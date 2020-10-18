package com.petcare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.petcare.entities.Bill;
import com.petcare.entities.BillDetail;
import com.petcare.entities.BillDetailIdentity;
import com.petcare.entities.BillStatus;
import com.petcare.entities.EBillStatus;
import com.petcare.entities.Product;
import com.petcare.entities.User;
import com.petcare.payload.request.BillDetailRequest;
import com.petcare.payload.request.BillRequest;
import com.petcare.payload.response.BillDetailResponse;
import com.petcare.payload.response.BillResponse;
import com.petcare.repositories.BillDetailRepository;
import com.petcare.repositories.BillRepository;
import com.petcare.repositories.BillStatusRepository;
import com.petcare.repositories.ProductRepository;
import com.petcare.repositories.UserRepository;
import com.petcare.services.IBillService;

@Component
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillRepository billRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BillDetailRepository billDetailRepository;

	@Autowired
	private BillStatusRepository billStatusRepository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	@Override
	public String save(BillRequest billRequest) {
		Bill bill = new Bill();
		if (billRequest.getId() != null) {
			bill = billRepository.getOne(billRequest.getId());
		}
		bill.setAddress(billRequest.getAddress());
		bill.setCity(billRequest.getCity());
		bill.setEmail(billRequest.getEmail());
		bill.setPhoneNumber(billRequest.getPhoneNumber());
		bill.setTotal(billRequest.getTotal());
		bill.setPayment(billRequest.getPayment());

		// Set user
		User user = userRepository.findByUsername(billRequest.getUserName())
				.orElseThrow(() -> new RuntimeException("Error: Not exist username : " + billRequest.getUserName()));
		bill.setUser(user);

		// Set status
		if (billRequest.getStatus() == null) {
			BillStatus billStatus = billStatusRepository.findByStatusName(EBillStatus.UNPAID)
					.orElseThrow(() -> new RuntimeException("Error: BillStatus is not found."));
			bill.setBillStatus(billStatus);
		} else {
			if (billRequest.getStatus().equals(EBillStatus.UNPAID.toString())) {
				BillStatus billStatus = billStatusRepository.findByStatusName(EBillStatus.UNPAID)
						.orElseThrow(() -> new RuntimeException("Error: BillStatus is not found."));
				bill.setBillStatus(billStatus);
			} else if (billRequest.getStatus().equals(EBillStatus.PAID.toString())) {
				BillStatus billStatus = billStatusRepository.findByStatusName(EBillStatus.PAID)
						.orElseThrow(() -> new RuntimeException("Error: BillStatus is not found."));
				bill.setBillStatus(billStatus);
			}
		}

		bill = billRepository.save(bill);
		for (BillDetailRequest billDetailsReq : billRequest.getBillDetail()) {
			BillDetail tmp = new BillDetail();
			tmp.setPrice(billDetailsReq.getPrice());
			tmp.setQuantity(billDetailsReq.getQuantity());
			Product product = productRepository.findById(billDetailsReq.getIdProduct()).orElseThrow(
					() -> new RuntimeException("Error: Not exist productId = " + billDetailsReq.getIdProduct()));
			tmp.setProduct(product);
			Optional<Bill> billTmp = billRepository.findById(bill.getId());
			tmp.setBill(billTmp.get());

			BillDetailIdentity billDetailIdentity = new BillDetailIdentity(product.getId(), billTmp.get().getId());
			tmp.setBillDetailIdentity(billDetailIdentity);
			billDetailRepository.save(tmp);
		}

		return bill == null ? "Thao tác thất bại" : "Thao tác thành công";
	}

	@Override
	public void delete(long id) {
		List<BillDetail> billDetails = billDetailRepository.findAllByBillId(id);
		for (BillDetail billDetail : billDetails) {
			billDetailRepository.delete(billDetail);
		}

		billRepository.deleteById(id);
	}

	@Override
	public List<BillResponse> getAllBill() {
		List<BillResponse> result = new ArrayList<BillResponse>();
		List<Bill> bills = billRepository.findAll();
		for (Bill bill : bills) {
			BillResponse billResponse = new BillResponse();
			billResponse.setId(bill.getId());
			billResponse.setAddress(bill.getAddress());
			billResponse.setCity(bill.getCity());
			billResponse.setEmail(bill.getEmail());
			billResponse.setPhoneNumber(bill.getPhoneNumber());
			billResponse.setPayment(bill.getPayment());
			billResponse.setTotal(bill.getTotal());
			billResponse.setUserName(bill.getUser().getUsername());
			billResponse.setStatus(bill.getBillStatus().getStatusName().name());

			List<BillDetailResponse> billDetailResponses = new ArrayList<BillDetailResponse>();
			List<BillDetail> billDetails = billDetailRepository.findAllByBillId(billResponse.getId());
			for (BillDetail billDetail : billDetails) {
				BillDetailResponse billDetailResponse = new BillDetailResponse();
				billDetailResponse.setIdProduct(billDetail.getProduct().getId());
				billDetailResponse.setNameProduct(productRepository.findById(billDetail.getProduct().getId())
						.orElseThrow(() -> new RuntimeException()).getTitle());
				billDetailResponse.setPrice(billDetail.getPrice());
				billDetailResponse.setQuantity(billDetail.getQuantity());

				billDetailResponses.add(billDetailResponse);
			}
			billResponse.setBillDetail(billDetailResponses);

			result.add(billResponse);
		}
		return result;
	}

	@Override
	public List<BillResponse> getBillByUser(String un) {
		List<BillResponse> result = new ArrayList<BillResponse>();
		User user = userRepository.findByUsername(un).orElseThrow(() -> new RuntimeException("Error: not exist username: " + un));
		List<Bill> bills = billRepository.findAllByUser(user);
		for (Bill bill : bills) {
			BillResponse billResponse = new BillResponse();
			billResponse.setId(bill.getId());
			billResponse.setAddress(bill.getAddress());
			billResponse.setCity(bill.getCity());
			billResponse.setEmail(bill.getEmail());
			billResponse.setPhoneNumber(bill.getPhoneNumber());
			billResponse.setPayment(bill.getPayment());
			billResponse.setTotal(bill.getTotal());
			billResponse.setUserName(bill.getUser().getUsername());
			billResponse.setStatus(bill.getBillStatus().getStatusName().name());

			List<BillDetailResponse> billDetailResponses = new ArrayList<BillDetailResponse>();
			List<BillDetail> billDetails = billDetailRepository.findAllByBillId(billResponse.getId());
			for (BillDetail billDetail : billDetails) {
				BillDetailResponse billDetailResponse = new BillDetailResponse();
				billDetailResponse.setIdProduct(billDetail.getProduct().getId());
				billDetailResponse.setNameProduct(productRepository.findById(billDetail.getProduct().getId())
						.orElseThrow(() -> new RuntimeException()).getTitle());
				billDetailResponse.setPrice(billDetail.getPrice());
				billDetailResponse.setQuantity(billDetail.getQuantity());

				billDetailResponses.add(billDetailResponse);
			}
			billResponse.setBillDetail(billDetailResponses);

			result.add(billResponse);
		}
		return result;
	}

}
