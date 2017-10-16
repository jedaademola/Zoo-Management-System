package edu.mum.mpp.controller;


import edu.mum.mpp.exceptions.BadRequestException;
import edu.mum.mpp.exceptions.ConflictException;
import edu.mum.mpp.model.Block;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.model.Response;
import edu.mum.mpp.service.BlockService;
import edu.mum.mpp.util.CustomResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/zoo")
public class BlockController {

    @Autowired
    BlockService blockService;


    @RequestMapping(value = "/block/paging", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN','ROLE_VIEW_ALL_USERS')")
    public Page<Block> getBlocks(
            @RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
            @RequestParam(value = "pageSize", defaultValue = "20") Long pageSize) throws Exception {
        return blockService.getBlocks(pageNum, pageSize);
    }

    @RequestMapping(value = "/manageBlock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> manageBlock(@RequestBody @Valid Block block) throws Exception {

        if (block.getName() == null || block.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block Name cannot be empty");

        if (block.getLocation() == null || block.getLocation().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Location cannot be empty");

        if (blockService.checkBlock(block.getName(), block.getLocation())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Block already exist");
        }

        long id = blockService.manageBlock(block);

        Response resp = new Response();


        HttpStatus httpCode = (id > 0L) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((id > 0L) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);

    }


    @RequestMapping(value = "/block", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated Block block) {

        // ObjectMapper objectMapper = new ObjectMapper();

        if (block.getName() == null || block.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block Name cannot be empty");

        if (block.getLocation() == null || block.getLocation().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Location cannot be empty");

        if (blockService.checkBlock(block.getName(), block.getLocation())) {
            throw new ConflictException(CustomResponseCode.INVALID_REQUEST, " Block already exist");
        }

        //    User user = TokenService.getCurrentUserFromSecurityContext();
        //   role.setCreatedBy(user.getId());

        Response resp = new Response();
        blockService.create(block);
        HttpStatus httpCode = (block.getId() > 0) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((block.getId() > 0) ? "Operation successful" : "Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }

    @RequestMapping(value = "/block", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> edit(@RequestBody @Validated Block block) {

        if (block.getId() < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block Id cannot be empty");

        if (block.getName() == null || block.getName().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block Name cannot be empty");

        if (block.getLocation() == null || block.getLocation().isEmpty())
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Location cannot be empty");

        Block blockTemp = blockService.getSingleBlock(block.getId());
        if (blockTemp == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, " Block does not exist");
        }


        Response resp = new Response();
        blockService.editBlock(block);
        HttpStatus httpCode = (block.getId() > 0) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        resp.setDescription((block.getId() > 0) ? "Edit Operation successful" : "Edit Operation failed");

        return new ResponseEntity<>(resp, httpCode);
    }


    @RequestMapping(value = "/block", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Block> getBlocks() {
        return blockService.getBlocks(1, 20).getContent();
    }


    @RequestMapping(value = "/block/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Block getBlockById(@PathVariable long id) {

        if (id < 1)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block Id cannot be empty");

        Block block = blockService.getSingleBlock(id);
        if (block == null) {
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "Block does not exist");
        }

        return block;
    }
}
