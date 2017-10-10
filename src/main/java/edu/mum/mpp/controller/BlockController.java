package edu.mum.mpp.controller;


import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.exceptions.ConflictException;
import edu.mum.mpp.model.Block;
import edu.mum.mpp.service.BlockService;
import edu.mum.mpp.util.CustomResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/zoo")
public class BlockController {

    @Autowired
    BlockService blockService;

    @RequestMapping(value = "/block", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)

    public void create(@RequestBody @Validated Block block) {

        if (block.getName() == null || block.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block Name cannot be empty");

        if (block.getLocation() == null || block.getLocation().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Location cannot be empty");

        if (blockService.checkBlock(block.getName(), block.getLocation())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Block already exist");
        }

        //    User user = TokenService.getCurrentUserFromSecurityContext();
        //   role.setCreatedBy(user.getId());

        blockService.create(block);
    }


    @RequestMapping(value = "/block", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Block> getBlocks() {
        return blockService.getBlocks();
    }
}
