package com.palladium.kenyaemril.controller;

import com.palladium.kenyaemril.model.KenyaEMRILMessage;
import com.palladium.kenyaemril.utils.PostUtil;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KenyaEMRILController {
    @RequestMapping(value = "/kenyaemrapi", method = RequestMethod.POST)
    public void greeting(@RequestBody String s) {
        String hel7Type = new JSONObject(s).getJSONObject("MESSAGE_HEADER").getString("MESSAGE_TYPE");
        KenyaEMRILMessage kenyaEMRILMessage = new KenyaEMRILMessage();
        kenyaEMRILMessage.setMessageId(1);
        kenyaEMRILMessage.setMessage(s);
        kenyaEMRILMessage.setHl7Type(hel7Type);
        kenyaEMRILMessage.setMessageType(1);
        new PostUtil<KenyaEMRILMessage>().makePostRequest(kenyaEMRILMessage);
    }
}
