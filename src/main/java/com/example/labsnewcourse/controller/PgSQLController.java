package com.example.labsnewcourse.controller;

import com.example.labsnewcourse.model.PGDocumentsEntity;
import com.example.labsnewcourse.model.PGDocumentsEntityDTO;
import com.example.labsnewcourse.model.SuccessDTOResponse;
import com.example.labsnewcourse.service.PgSQLService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Work with office documents"})
@SwaggerDefinition(tags = {@Tag(name = "Work with office documents", description = "Work with office documents REST API")})
@RestController
@RequestMapping("/api/pgsql")
public class PgSQLController {
    @Autowired
    private PgSQLService pgSQLService;

    @Operation(summary = "Create document")
    @ApiResponse(code = 200, message = "Document created", response = PGDocumentsEntity.class)
    @PostMapping("/document")
    public @ResponseBody PGDocumentsEntity createDocument(@RequestBody PGDocumentsEntityDTO pgDocumentsEntityDTO){
        return pgSQLService.createDocument(pgDocumentsEntityDTO);
    }
    @Operation(summary = "Update document")
    @ApiResponse(code = 200, message = "Document updating", response = PGDocumentsEntity.class)
    @PutMapping("/document")
    public @ResponseBody PGDocumentsEntity updateDocument(@RequestParam Integer id, @RequestBody PGDocumentsEntityDTO pgDocumentsEntityDTO){
        return pgSQLService.update(id, pgDocumentsEntityDTO);
    }
    @Operation(summary = "Find document")
    @ApiResponse(code = 200, message = "Document finding", response = PGDocumentsEntity.class)
    @GetMapping("/document")
    public PGDocumentsEntity findDocument(@RequestParam Integer id) {
        return pgSQLService.find(id);
    }
    @Operation(summary = "Delete document")
    @ApiResponse(code = 200, message = "Document deleted", response = SuccessDTOResponse.class)
    @DeleteMapping("/document")
    public SuccessDTOResponse deleteDocument(@RequestParam Integer id) {
        pgSQLService.delete(id);
        SuccessDTOResponse successDTOResponse = new SuccessDTOResponse();
        successDTOResponse.setResult(true);
        return successDTOResponse;
    }
}
