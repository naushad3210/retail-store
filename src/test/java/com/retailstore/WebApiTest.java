package com.retailstore;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailstore.controller.BillController;
import com.retailstore.datastub.BillDataStub;
import com.retailstore.dto.request.BillRequestDto;
import com.retailstore.service.IBillService;

@RunWith(SpringRunner.class)
@WebMvcTest(BillController.class)
public class WebApiTest {
	
	@MockBean
	IBillService billServiceMock;
	
	@Autowired
    private MockMvc mockMvc;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@Test
    public void generateBillNegetiveBillAmountException() throws Exception {

		when(billServiceMock.generateBill(Mockito.any(BillRequestDto.class))).thenReturn(BillDataStub.billDetails());

        String res = mockMvc.perform(post("/bill")
            .content(mapper.writeValueAsString(BillDataStub.billRequestExceptiontDto("NegetiveBillAmount")))
            .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest())
            .andReturn()
            .getResponse()
            .getContentAsString();

    }
	@Test
    public void generateBillEmptyItemTypeException() throws Exception {

		when(billServiceMock.generateBill(Mockito.any(BillRequestDto.class))).thenReturn(BillDataStub.billDetails());

        String res = mockMvc.perform(post("/bill")
            .content(mapper.writeValueAsString(BillDataStub.billRequestExceptiontDto("EmptyItemType")))
            .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest())
            .andReturn()
            .getResponse()
            .getContentAsString();

    }
	@Test
    public void generateBillEmptyUserTypeException() throws Exception {

		when(billServiceMock.generateBill(Mockito.any(BillRequestDto.class))).thenReturn(BillDataStub.billDetails());

        String res = mockMvc.perform(post("/bill")
            .content(mapper.writeValueAsString(BillDataStub.billRequestExceptiontDto("EmptyUserType")))
            .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest())
            .andReturn()
            .getResponse()
            .getContentAsString();

    }
	@Test
    public void generateBillEmptyUserIdException() throws Exception {

		when(billServiceMock.generateBill(Mockito.any(BillRequestDto.class))).thenReturn(BillDataStub.billDetails());

        String res = mockMvc.perform(post("/bill")
            .content(mapper.writeValueAsString(BillDataStub.billRequestExceptiontDto("EmptyUserId")))
            .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest())
            .andReturn()
            .getResponse()
            .getContentAsString();

    }
	
	

}
